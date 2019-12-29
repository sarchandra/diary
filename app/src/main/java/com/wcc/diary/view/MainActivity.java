package com.wcc.diary.view;

import android.app.Person;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import com.wcc.diary.R;
import com.wcc.diary.repository.DiaryDBImp;
import com.wcc.diary.repository.entity.DiaryItem;
import com.wcc.diary.viewmodel.PersonViewModel;
import androidx.fragment.app.Fragment;
public class MainActivity extends AppCompatActivity {

    PersonViewModel mPerson;
    Fragment calendarView;
    Fragment textView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(calendarView);
                    return true;
                case R.id.navigation_dashboard:
                    loadFragment(textView);

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
       // UserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setContentView(R.layout.activity_main);
        mPerson = ViewModelProviders.of(this).get(PersonViewModel.class);
        mPerson.setFirstname("first viewmodel");


        textView = new TextFragment();
        calendarView = new CalendarFragment();
        loadFragment(calendarView);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private  void DBTest(){
      //  DiaryItem item = new DiaryItem('2019-12-29","test project","imgulr test");
       // DiaryDBImp.getInstance().getDiaryDAO().insert();
    }

}
