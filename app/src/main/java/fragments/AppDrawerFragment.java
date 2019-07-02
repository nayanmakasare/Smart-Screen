package fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tv.cloudwalker.smartlauncher.R;
import tv.cloudwalker.smartlauncher.databinding.AppDrawerLayoutBinding;

public class AppDrawerFragment extends DialogFragment
{
    private AppDrawerLayoutBinding appDrawerLayoutBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        appDrawerLayoutBinding = DataBindingUtil.inflate(inflater , R.layout.app_drawer_layout, container , false);
        return appDrawerLayoutBinding.getRoot();
    }

}
