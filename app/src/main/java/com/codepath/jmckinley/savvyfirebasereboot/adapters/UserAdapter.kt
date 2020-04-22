package com.codepath.jmckinley.savvyfirebasereboot.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codepath.jmckinley.savvyfirebasereboot.Models.Users
import com.codepath.jmckinley.savvyfirebasereboot.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.user_search_item_layout.view.*

class UserAdapter(
        mContext: Context,
        mUsers: List<Users>,
        isChatCheck: Boolean
        ) : RecyclerView.Adapter<UserAdapter.ViewHolder?>()
{

    private val mContext: Context
    private val mUsers: List<Users>
    private val isChatCheck: Boolean

    init {
        this.mContext = mContext
        this.mUsers = mUsers
        this.isChatCheck = isChatCheck

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.user_search_item_layout, parent, false)
        return UserAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: Users? = mUsers[position]
        holder.username_search.text = user!!.getUsername()
        Picasso.get().load(user.getProfileImage()).placeholder(R.drawable.profileimage).into(holder.profile_image)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var username_search: TextView
        var image_online_search: CircleImageView
        var image_offline_search: CircleImageView
        var profile_image: CircleImageView
        var message_last: TextView

        init {
            username_search = itemView.findViewById(R.id.username_search)
            image_online_search = itemView.findViewById(R.id.image_online_search)
            image_offline_search = itemView.findViewById(R.id.image_offline_search)
            profile_image = itemView.findViewById(R.id.profile_image)
            message_last = itemView.findViewById(R.id.message_last)
        }

    }

}