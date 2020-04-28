package com.codepath.jmckinley.savvyfirebasereboot.activities

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codepath.jmckinley.savvyfirebasereboot.Models.Users
import com.codepath.jmckinley.savvyfirebasereboot.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageTask
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_message_chat.*

class MessageChatActivity : AppCompatActivity() {

    private val TAG: String = "MessageChatActivity"

    var userIdVisit: String = ""
    var firebaseUser: FirebaseUser? = null

    // when the view is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_chat)

        // get the intent from search activity
        intent = intent
        userIdVisit = intent.getStringExtra("visit_id")     // the id of the Receiver
        firebaseUser = FirebaseAuth.getInstance().currentUser     // the id of the Sender

        // create a reference to the realtime database
        val reference = FirebaseDatabase.getInstance()
                .reference
                .child("Users")
                .child(userIdVisit)

        // attach a listener to the database
        reference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            // when data is changed in the database
            override fun onDataChange(p0: DataSnapshot) {
                val user: Users? = p0.getValue(Users::class.java)
                username_mchat.text = user!!.getUsername()
                Picasso.get().load(user.getProfileImage()).into(profile_image_chat)
            }

        })

        // when the button is clicked
        send_messge_btn.setOnClickListener{

            // grab the text from text field
            val message = text_message_chat.text.toString()
            // ensure message has text
            if (message == ""){
                Toast.makeText(this@MessageChatActivity, "Please enter a message first...", Toast.LENGTH_SHORT).show()
            } else {
                sendMessage(firebaseUser!!.uid, userIdVisit, message)
            }
            // reset message text box to empty
            text_message_chat.setText("")
        }

        // TODO: Allow user to send file attachments
        attach_image_file_btn.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent, "Select image"), 438)
        }


    }

    // TODO: This is where the trouble starts
    // TODO: Start the scavenger hunt here
    @SuppressLint("StringFormatInvalid") // TODO: This shouldn't be here but Android Studio Forces it to be added to run
    private fun sendMessage(senderId: String, receiver: String?, message: String) {

        // get a refference to the realtime database
        val reference = FirebaseDatabase.getInstance().reference
        // get the private message key
        val messageKey = reference.push().key

        // create a hash map of the data packet for messages
        val messageHashMap = HashMap<String, Any?>()
        messageHashMap["sender"] = senderId
        messageHashMap["receiver"] = receiver
        messageHashMap["message"] = message
        messageHashMap["isseen"] = false
        messageHashMap["url"] = ""
        messageHashMap["messageId"] = "messageKey"

        // in the Chats child directory
        reference.child("Chats")
                .child(messageKey!!)
                .setValue(messageHashMap)
                .addOnCompleteListener(){task ->
                    if (task.isSuccessful)
                    {
                        // add recipient to chat fragment for the sender
                        val chatListReference = FirebaseDatabase.getInstance()
                                .reference
                                .child("ChatList")
                                .child(firebaseUser!!.uid)
                                .child(userIdVisit)

                        chatListReference.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(p0: DataSnapshot) {
                                if (!p0.exists())
                                {
                                    chatListReference.child("id").setValue(userIdVisit)
                                }

                                // add sender to chat fragment for the receiver
                                val chatListReceiverReference = FirebaseDatabase.getInstance()
                                        .reference
                                        .child("ChatList")
                                        .child(userIdVisit)
                                        .child(firebaseUser!!.uid)
                                chatListReceiverReference.child("id").setValue(firebaseUser!!.uid)
                            }

                            override fun onCancelled(p0: DatabaseError) {
                                TODO("Not yet implemented")
                            }

                        })






                        val reference = FirebaseDatabase.getInstance().reference
                                .child("Users").child(firebaseUser!!.uid)

                        // TODO: Continue when starting on push notifications
                    }
                }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 438 && resultCode == RESULT_OK && data!=null && data!!.data != null)
        {
            val progressBar = ProgressDialog(this)
            progressBar.setMessage("image is currently loading, please wait...")
            progressBar.show()

            val fileUri = data.data
            val storageReference = FirebaseStorage.getInstance().reference.child("Chat Images")
            val ref = FirebaseDatabase.getInstance().reference
            val messageId = ref.push().key
            val filePath = storageReference.child("$messageId.jpg")

            var uploadTask: StorageTask<*>
            uploadTask = filePath.putFile(fileUri!!)

//            uploadTask.continueWithTask(Continuation <UploadTask.TaskSnapshot, Task <Uri>>{ task ->
//                if (!task.isSuccessful)
//                {
//                    task.exception?.let
//                    {
//                        throw it
//                    }
//                }
//                return@Continuation fileRef.downloadUri
//            }).addOnCompleteListener { task ->
//
//            }
        }

    }
}





























// Creating user to user chat
//    1. Make authentication, eventually you get Firebase TokenId and userId
//    2. Send them to your server side and store it in DB
//    3. When you are going to send a message you need create json and put inside topic text and resipent userId so on...
//    4. Send this json via HTTP to your server side
//    5. When server retrive this json, it should use Firebase API to create new message bloc child with random name in firebase
//    6. Eventually server have to find recipent user in DB by userId that we get from message.
//    7. After server will find current recipent user by userId , next we should take firebase tokenId In order to sent notification .
//    8. And send recipent user notification with such data - name of new message bloc child
//    9. Recipent will connect to this current bloc and retrive data



//   MessageChatActivity var userIdVisit: String = ""
//    var firebaseUser: FirebaseUser? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_message_chat)
//
//        intent = intent
//        userIdVisit = intent.getStringExtra("visit_id")
//        firebaseUser = FirebaseAuth.getInstance().currentUser
//
//        val reference = FirebaseDatabase.getInstance().reference
//                .child("Users").child(userIdVisit)
//        reference.addValueEventListener(object : ValueEventListener {
//            override fun onCancelled(p0: DatabaseError) {
//
//            }
//
//            override fun onDataChange(p0: DataSnapshot) {
//                val user: Users? = p0.getValue(Users::class.java)
//                username_mchat.text = user!!.getUsername()
//                Picasso.get().load(user.getProfileImage()).into(profile_image_chat)
//            }
//
//        })
//
//
//        send_messge_btn.setOnClickListener{
//            val message = text_message_chat.text.toString()
//            if (message == ""){
//                Toast.makeText(this@MessageChatActivity, "Please enter a message first...", Toast.LENGTH_SHORT).show()
//            } else {
//                sendMessage(firebaseUser!!.uid, userIdVisit, message)
//            }
//
//
//        }
//
//
//        attach_image_file_btn.setOnClickListener{
//            val intent = Intent()
//            intent.action = Intent.ACTION_GET_CONTENT
//            intent.type = "image/*"
//            startActivityForResult(Intent.createChooser(intent, "Select image"), 438)
//        }
//
//
//    }
//
//    @SuppressLint("StringFormatInvalid")
//    private fun sendMessage(senderId: String, recieverId: String?, message: String) {
//
//        val reference = FirebaseDatabase.getInstance().reference
//        val messageKey = reference.push().key
//
//        val messageHashMap = HashMap<String, Any?>()
//        messageHashMap["sender"] = senderId
//        messageHashMap["reciever"] = recieverId
//        messageHashMap["message"] = message
//        messageHashMap["isseen"] = false
//        messageHashMap["url"] = null
//        messageHashMap["messageId"] = "messageKey"
//
//        reference.child("Chats")
//                .child(messageKey!!)
//                .setValue(messageHashMap)
//                .addOnCompleteListener(){task ->
//                    if (task.isSuccessful) {
//                        val chatListReference = FirebaseDatabase.getInstance()
//                                .reference.child("ChatList")
//
//                        chatListReference.child("id").setValue(firebaseUser!!.uid)
//                        val reference = FirebaseDatabase.getInstance().reference
//                                .child("Users").child(firebaseUser!!.uid)
//
//                        // TODO: Continue when starting on push notifications
//                    }
//                }
//
//
//
//
//    }
//
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 438 && resultCode == Activity.RESULT_OK && data!!.data != null){
//            val loadingBar = ProgressDialog(applicationContext)
//            loadingBar.setMessage("Please wait, image is sending...")
//            loadingBar.show()
//
//            val fileUri = data.data
//            val storageReference = FirebaseStorage.getInstance().reference.child("Chat Images")
//            val ref = FirebaseDatabase.getInstance().reference
//            val messageId = ref.push().key
//            val filePath = storageReference.child("$messageId.jpg")
//
//            var uploadTask: StorageTask<*>
//            uploadTask = filePath.putFile(fileUri!!)
//
//            uploadTask.continueWithTask(Continuation <UploadTask.TaskSnapshot, Task<URI>>){task ->
////            uploadTask.continueWithTask(Continuation <UploadTask.TaskSnapshot, Task <Uri>>{task ->
//                if (!task.isSuccessful)
//                {
//                    task.exception?.let
//                    {
//                        throw it
//                    }
//                }
//                return@Continuation fileRef.downloadUri
//            }
//        }
//
//    }
//}
