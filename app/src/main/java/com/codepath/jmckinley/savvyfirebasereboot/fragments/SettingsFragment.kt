package com.codepath.jmckinley.savvyfirebasereboot.fragments

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.codepath.jmckinley.savvyfirebasereboot.Models.Users

import com.codepath.jmckinley.savvyfirebasereboot.R
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.view.*

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment() {

    val TAG: String = "MainActivity_"
    private val REQUEST_CODE = 438;
    private var imageURI: Uri? = null
    private var storageRef: StorageReference? = null
    private var coverChecker: String? = null
    private var socialCheck: String? = null

    var firestoreDB = FirebaseFirestore.getInstance()
    var fireBaseUser = FirebaseAuth.getInstance().currentUser

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        storageRef = FirebaseStorage.getInstance().reference.child("userImages")

        val docRef = firestoreDB.collection("users").document(fireBaseUser!!.uid)
        docRef.get()
                .addOnSuccessListener { documentSnapshot ->
                    if(documentSnapshot.exists()){
                        // store snapshot into
                        val user: Users? = documentSnapshot.toObject(Users::class.java)


                        // get profile image and username to display on toolbar
                        username_settings.text = user!!.getUsername()
                        Picasso.get().load(user.getProfileImage()).placeholder(R.drawable.profileimage).into(profile_image_settings)
                        Picasso.get().load(user.getCoverImage()).placeholder(R.drawable.coverphoto).into(cover_image_settings)
                    }
                }


        view.profile_image_settings.setOnClickListener {
            pickImageFile()
        }

        view.cover_image_settings.setOnClickListener {
            coverChecker = "cover"
            pickImageFile()
        }

        view.set_linkedin.setOnClickListener {
            socialCheck = "linkedin"
            setSocialLink()
        }

        view.set_website.setOnClickListener {
            socialCheck = "website"
            setSocialLink()
        }

        return view
    }

    private fun setSocialLink() {
        val builder: AlertDialog.Builder =
                AlertDialog.Builder(requireContext(), R.style.Theme_AppCompat_DayNight_Dialog_Alert)

        if (socialCheck == "website") {
            builder.setTitle("Write Url: ")
        } else {
            builder.setTitle("Write LinkedIn Name: ")
        }
        val editText = EditText(context)

        if (socialCheck == "website") {
            editText.hint = "e.g. www.example.com"
        } else {
            editText.hint = "e.g. username"
        }
        builder.setView(editText)

        builder.setPositiveButton("Create", DialogInterface.OnClickListener { dialog, which ->
            var str = editText.text.toString()

            if (str == null) {
                Toast.makeText(context, "Cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                saveSocialLink(str)
            }
        })

        builder.setPositiveButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
            dialog.cancel()
        })

        builder.show()
    }

    private fun saveSocialLink(str: String) {
        TODO("Not yet implemented")
    }


    private fun pickImageFile(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, REQUEST_CODE ) // send user to mobile phone gallary to select image
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // if the request code matches this activity
        // if the result code is ok
        // if the data payload isnt empty, then...
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data!!.data != null){
            // pass image data to imageUri
            imageURI = data.data
            Toast.makeText(context, "uploading...", Toast.LENGTH_SHORT).show()
            uploadImage()

        }
    }

    private fun uploadImage(){
        val progressBar = ProgressDialog(context)
        progressBar.setMessage("image is currently loading, please wait...")
        progressBar.show()

        // to prevent users from overwriting each others image in storage create a unique file name using time
        if(imageURI != null){
            // TODO: only add timestamp if image name already exist in storage
            val fileRef = storageRef!!.child(System.currentTimeMillis().toString() + ".jpg")

            var uploadTask: StorageTask<*>
            uploadTask = fileRef.putFile(imageURI!!)

            uploadTask.continueWithTask(Continuation <UploadTask.TaskSnapshot, Task<Uri>>{ task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                return@Continuation fileRef.downloadUrl
            }).addOnCompleteListener{ task ->
                if(task.isSuccessful()){
                    val downloadUrl = task.result
                    val fileUrl = downloadUrl.toString()

                    val dbRef = firestoreDB.collection("users").document(fireBaseUser!!.uid)

                    if(coverChecker == "cover") {
                        // save image as cover image
                        dbRef.update("coverImage", fileUrl)
                        coverChecker = ""
                    } else {
                        // save image as profile image
                        dbRef.update("profileImage", fileUrl)
                        coverChecker = ""
                    }
                    progressBar.dismiss()

                    val docRef = firestoreDB.collection("users").document(fireBaseUser!!.uid)
                    docRef.get()
                            .addOnSuccessListener { documentSnapshot ->
                                if(documentSnapshot.exists()){
                                    // store snapshot into
                                    val user: Users? = documentSnapshot.toObject(Users::class.java)

                                    // get profile image and username to display on toolbar
                                    username_settings.text = user!!.getUsername()

                                    Picasso.get().load(user.getProfileImage()).placeholder(R.drawable.profileimage).into(profile_image_settings)
                                    Picasso.get().load(user.getCoverImage()).placeholder(R.drawable.coverphoto).into(cover_image_settings)
                                }
                            }

                }
            }
        }

    }

}
