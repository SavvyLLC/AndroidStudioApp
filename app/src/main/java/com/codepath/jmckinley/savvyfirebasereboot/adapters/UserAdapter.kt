package com.codepath.jmckinley.savvyfirebasereboot.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codepath.jmckinley.savvyfirebasereboot.Models.Users
import com.codepath.jmckinley.savvyfirebasereboot.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.user_search_item_layout.view.*

class UserAdapter(
        mContext: Context,
        mUsers: List<Users>,
        isChatCheck: Boolean
        ) : RecyclerView.Adapter<UserAdapter.ViewHolder?>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
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