package com.example.mcashui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import android.widget.Toolbar;

import com.example.mcashui.ui.bInvite.bInviteFragment;
import com.example.mcashui.ui.faq.FAQFragment;
import com.example.mcashui.ui.helpAndSupport.helpAndSupport;
import com.example.mcashui.ui.inviteAFriend.inviteFriend;
import com.example.mcashui.ui.privacyPolicy.privacypolicy;
import com.example.mcashui.ui.quiz.QuizFragment;
import com.example.mcashui.ui.rateUs.rateUs;
import com.example.mcashui.ui.redeem.redeem;
import com.example.mcashui.ui.transaction.transaction;
import com.example.mcashui.ui.wallet.walletFragment;
import com.google.android.material.navigation.NavigationBarView;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mcashui.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;
    Toolbar toolbar;

    ActivityMainBinding activityMainBinding;


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.navView.setNavigationItemSelectedListener(this);

        activityMainBinding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
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
                    Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://nkixlwewf.play.gamezop.com/en/intro?int-nav=1"));
                    startActivity(intent);
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
        setSupportActionBar(activityMainBinding.appBarMain.toolbar);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_redeem, R.id.nav_transaction,R.id.nav_helpAndSupport,R.id.nav_inviteAFriend,R.id.nav_privacyPolicy,R.id.nav_rateUs,R.id.action_FAQ,R.id.action_InviteFriend,R.id.action_gameredirect,R.id.action_quiz,R.id.action_wallet).setOpenableLayout(activityMainBinding.drawerLayout).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(activityMainBinding.navView, navController);
        fragmentManager =getSupportFragmentManager();

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

    private void helpAndSupportEmail(String to_email){
        Intent helpmail=new Intent(Intent.ACTION_SEND);
        helpmail.putExtra(Intent.EXTRA_EMAIL, new String[]{to_email});
        helpmail.putExtra(Intent.EXTRA_SUBJECT, (String) null);
        helpmail.putExtra(Intent.EXTRA_TEXT,(String) null);
        helpmail.setType("message/rfc822");
        startActivity(Intent.createChooser(helpmail ,"Choose email client: "));
    }
}