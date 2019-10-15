package ocw.neuberfran.com.rxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.logging.Level;
import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscription;
import rx.functions.Action1;
import ocw.neuberfran.com.rxandroid.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MaintActivity";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
    }
    public void testar (View v) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory( GsonConverterFactory.create() )
                .baseUrl( MarsServices.MARS_API_BASE_URL )
                .build();

        MarsServices marsServices = retrofit.create(MarsServices.class);
        Call < MarsReport > call = marsServices.latest();

        call.enqueue( new Callback < MarsReport >() {
            @Override
            public void onResponse(Call < MarsReport > call, Response < MarsReport > response) {
                Toast.makeText(MainActivity.this, response.body().max_temp+"",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call < MarsReport > call, Throwable t) {

            }
        } );

    }
}