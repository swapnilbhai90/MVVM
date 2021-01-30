package com.fitrango.presentation.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.fitrango.R
import com.fitrango.presentation.di.Injector
import com.fitrango.presentation.view.banner.BannerActivity
import com.fitrango.presentation.view.login.mobileLogin.MobileLogin
import com.fitrango.presentation.view.login.socialSignup.SocialSignup
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_activity.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject


class LoginActivity: AppCompatActivity(), View.OnClickListener {

    lateinit var mGoogleSignInClient: GoogleSignInClient
    lateinit var callbackManager: CallbackManager
    private lateinit var auth: FirebaseAuth
    @Inject
    lateinit var factory: LoginViewModelFactory
    private lateinit var movieViewModel: LoginViewModel
    private val EMAIL = "email"

    // [END declare_auth]
    private lateinit var googleSignInClient: GoogleSignInClient
    var  RC_SIGN_IN=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        callbackManager = CallbackManager.Factory.create();
       initUIListener()
       initMVVM()
        initFB()



        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.

// Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()




    }

    private fun initFB() {
        callbackManager = CallbackManager.Factory.create()


        LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult?> {
                override fun onSuccess(loginResult: LoginResult?) {

                    Timber.e("Login result" + loginResult.toString())

                    val request = GraphRequest.newMeRequest(
                        loginResult?.accessToken
                    ) { `object`, response ->

                        //check in database user exist
                        Toast.makeText(applicationContext,"check in database user exist",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity, SocialSignup::class.java))
                        finish()
                    }
                    val parameters = Bundle()
                    parameters.putString("fields", "id,name,link,birthday,email")
                    request.parameters = parameters
                    request.executeAsync()
                    // App code
                }

                override fun onCancel() {
                    // App code
                }

                override fun onError(exception: FacebookException) {
                    // App code
                }
            })

    }

    private fun initMVVM() {
        (application as Injector).createLoginSubComponent().inject(this)
        movieViewModel= ViewModelProvider(this, factory)
            .get(LoginViewModel::class.java)

        /*      movieViewModel.getMovies("swapnil bhai", "123", "1234", "mumbai", "afa").observe(
                  this,
                  Observer {
                      Log.e("data", it!!.data.message)
                  })*/
    }

    private fun initUIListener() {
        layout_button_fb.setOnClickListener(this)
        layout_button_google.setOnClickListener(this)
        layout_button_mobile.setOnClickListener(this)
    }


    private fun signIn() {
    /*    val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)*/
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d("Google", "firebaseAuthWithGoogle:" + account.id)

            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("Google", "Google sign in failed", e)
                // ...
            }
        }
        else
        callbackManager.onActivityResult(requestCode, resultCode, data)

    }


    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            //updateUI(account)
            Log.w("Google Result", "signInResult:failed code=   " + "Success")

        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Google Result", "signInResult:failed code=" + e.statusCode)
           // updateUI(null)
        }
    }

    override fun onClick(view: View?) {

        when(view?.id){
            layout_button_fb.id ->
                fb_login_button.performClick()
            layout_button_google.id ->
                signIn()
            layout_button_mobile.id->
                mobile_login()

        }

    }

    private fun mobile_login() {
        startActivity(Intent(this@LoginActivity, MobileLogin::class.java))

    }

}