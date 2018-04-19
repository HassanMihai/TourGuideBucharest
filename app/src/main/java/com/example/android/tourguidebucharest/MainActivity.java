package com.example.android.tourguidebucharest;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.museum,
            R.drawable.nature,
            R.drawable.food,
            R.drawable.dancing
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        // Find the tab layout that shows the tabs
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    // Setup the icons of the tabs
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    // Setup view pager fragments
    private void setupViewPager(ViewPager viewPager) {
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        adapter.addFrag(new MuseumsFragment(), getString(R.string.museums));
        adapter.addFrag(new ParksFragment(), getString(R.string.parks));
        adapter.addFrag(new FoodFragment(), getString(R.string.food));
        adapter.addFrag(new NightLifeFragment(), getString(R.string.night_life));
        viewPager.setAdapter(adapter);
    }
}
