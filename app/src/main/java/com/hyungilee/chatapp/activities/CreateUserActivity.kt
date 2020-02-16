package com.hyungilee.chatapp.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hyungilee.chatapp.R
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"
    // [R, G, B, [alpha value]]
    var avatarColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun generateUserAvatar(view: View){
        // dark light
        // resource 0~27
        val random = Random()
        // 0 < x < 2
        val color = random.nextInt(2)
        // 0 < x < 28
        val avatar = random.nextInt(28)

        if(color == 0){
            userAvatar = "light$avatar"
        }else{
            userAvatar = "dark$avatar"
        }
        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        createAvatarImageView.setImageResource(resourceId)
    }

    fun generateColorClicked(view: View){
        // R, G, B
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)
        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))
        // savedR,G,B value will be saved api database
        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "{$savedR, $savedG, $savedB, 1}"
    }

    fun createUserClicked(view: View){

    }

}
