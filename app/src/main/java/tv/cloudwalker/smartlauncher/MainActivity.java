package tv.cloudwalker.smartlauncher;

import android.content.ClipData;
import android.content.ClipDescription;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import tv.cloudwalker.smartlauncher.databinding.ActivityMainBinding;
import utils.MyDragShadowBuilder;

public class MainActivity extends AppCompatActivity  implements View.OnDragListener {

    private ActivityMainBinding activityMainBinding ;
    private static final String TAG = "MainActivity";
    private String  IMAGEVIEW_TAG = "appIcon" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding  = DataBindingUtil.setContentView(this, R.layout.activity_main);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        activityMainBinding.day.setText(dayOfTheWeek);
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String  currentTime = dateFormat.format(Calendar.getInstance().getTime());
        activityMainBinding.time.setText(currentTime);
        activityMainBinding.appDrawer.setTag(IMAGEVIEW_TAG);
        activityMainBinding.appDrawer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
                ClipData dragData = new ClipData((CharSequence)v.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                View.DragShadowBuilder builder = new View.DragShadowBuilder(v);
                v.startDrag(dragData, builder , null , 0);
                return true;
            }
        });

        activityMainBinding.mainRecyclerView
                .setLayoutManager(new GridLayoutManager(this , GridLayoutManager.DEFAULT_SPAN_COUNT , LinearLayoutManager.VERTICAL, false));

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.ACTION_STATE_DRAG ,ItemTouchHelper.ANIMATION_TYPE_DRAG) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                Log.d(TAG, "onMove: ");
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                Log.d(TAG, "onSwiped: ");
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(activityMainBinding.mainRecyclerView);

    }

    @Override
    public boolean onDrag(View v, DragEvent dragEvent) {
        switch(dragEvent.getAction()) {

            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(TAG, "onDrag: drag started.");

                return true;

            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(TAG, "onDrag: drag entered.");
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                Log.d(TAG, "onDrag: current point: ( " + dragEvent.getX() + " , " + dragEvent.getY() + " )"  );

                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(TAG, "onDrag: exited.");
                return true;

            case DragEvent.ACTION_DROP:

                Log.d(TAG, "onDrag: dropped.");

                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(TAG, "onDrag: ended.");
                return true;

            // An unknown action type was received.
            default:
                Log.e(TAG,"Unknown action type received by OnStartDragListener.");
                break;

        }
        return false;
    }
}
