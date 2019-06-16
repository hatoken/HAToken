package company.token.ha.hatoken.splash.view.activity

import android.os.Bundle
import company.token.ha.hatoken.R
import company.token.ha.hatoken.activity.BaseActivity
import company.token.ha.hatoken.main.view.activity.MainActivity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        compositeDisposable?.add(Single.timer(3000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                startActivity(MainActivity.createIntent(this))
            }))
    }
}
