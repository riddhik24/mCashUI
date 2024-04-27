package com.example.mcashui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import android.widget.Toolbar;

import com.example.mcashui.ui.bInvite.bInviteFragment;
import com.example.mcashui.ui.faq.FAQFragment;
import com.example.mcashui.ui.helpAndSupport.helpAndSupport;
import com.example.mcashui.ui.home.HomeFragment;
import com.example.mcashui.ui.inviteAFriend.inviteFriend;
import com.example.mcashui.ui.privacyPolicy.privacypolicy;
import com.example.mcashui.ui.quiz.QuizFragment;
import com.example.mcashui.ui.rateUs.rateUs;
import com.example.mcashui.ui.redeem.redeem;
import com.example.mcashui.ui.redirect.redirectFragment;
import com.example.mcashui.ui.transaction.transaction;
import com.example.mcashui.ui.wallet.walletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mcashui.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    Toolbar toolbar;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.mcashui.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout, binding.appBarMain.toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId= menuItem.getItemId();
                if(itemId== R.id.action_FAQ){
                    placeFragment(new FAQFragment());
                    return true;
                }
                else if(itemId ==R.id.action_InviteFriend){
                    placeFragment(new bInviteFragment());
                    return true;
                }
                else if(itemId== R.id.action_gameredirect){
                    placeFragment(new redirectFragment());
                    return true;
                }
                else if(itemId== R.id.action_quiz){
                    placeFragment(new QuizFragment());
                    return true;
                }
                else if(itemId == R.id.action_wallet){
                    placeFragment(new walletFragment());
                    return true;
                }
                return false;
            }
        });
        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView1 = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_redeem, R.id.nav_transaction,R.id.nav_helpAndSupport,R.id.nav_inviteAFriend,R.id.nav_privacyPolicy,R.id.nav_rateUs,R.id.action_FAQ,R.id.action_InviteFriend,R.id.action_gameredirect,R.id.action_quiz,R.id.action_wallet).setOpenableLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        fragmentManager =getSupportFragmentManager();
        placeFragment(new HomeFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId= menuItem.getItemId();
        if(itemId== R.id.nav_redeem){
            placeFragment(new redeem());
        }else if(itemId ==R.id.nav_transaction){
            placeFragment(new transaction());
        }else if(itemId== R.id.action_InviteFriend){
            placeFragment(new inviteFriend());
        }else if(itemId== R.id.nav_rateUs){
            placeFragment(new rateUs());
        }else if(itemId == R.id.nav_helpAndSupport){
            placeFragment(new helpAndSupport());
        }else if(itemId== R.id.nav_privacyPolicy){
            placeFragment(new privacypolicy());
        }
        return true;
    }


    private void placeFragment(Fragment fragment){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}