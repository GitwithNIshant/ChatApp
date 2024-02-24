package com.example.chatapp.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.chatapp.model.UserModel;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AndroidUtil {

    public static void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();

    }
    public static CollectionReference altUserCollectionRefrence(){
        return FirebaseFirestore.getInstance().collection("user");
    }
    public static void passUserModelAsIntent(Intent intent, UserModel model){
        intent.putExtra("username",model.getUsername());
        intent.putExtra("phone",model.getPhone());
        intent.putExtra("userId",model.getUserId());


    }
    public static UserModel getUserModelFromIntent(Intent intent){
        UserModel userModel = new UserModel();
        userModel.setUsername(intent.getStringExtra("username"));
        userModel.setPhone(intent.getStringExtra("phone"));
        userModel.setUserId(intent.getStringExtra("userId"));

        return userModel;
    }



}
