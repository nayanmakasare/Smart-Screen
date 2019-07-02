package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver
{

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void setTime()
    {

    }
}
