package project.is.IrVerde;

import android.util.Log;

import com.google.android.gms.plus.PlusClient;

public class SignOut {
    PlusClient mPlusClient;

    public SignOut(PlusClient mPlusClient){
        this.mPlusClient = mPlusClient;
    }

    public void signOut(){
        PlusClient mPlusClient = PlusBaseActivity.mPlusClient;
        if (mPlusClient.isConnected()) {
            // Clear the default account in order to allow the user to potentially choose a
            // different account from the account chooser.
            mPlusClient.clearDefaultAccount();
            //disconnect from the play services.
            mPlusClient.disconnect();
            Log.v("TAG", "Sign out successful!");
        }
    }
}
