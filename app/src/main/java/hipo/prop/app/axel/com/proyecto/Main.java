package hipo.prop.app.axel.com.proyecto;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class Main extends AppCompatActivity {
    ImageButton menuButton;
    Intent inTicket, inMenu, inMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuButton = findViewById(R.id.menuButton);

        inTicket = new Intent(this, Ticket.class);
        inMenu = new Intent(this,Menu.class);
        inMain = new Intent(this,Main.class);

        BannerSlider bannerSlider = findViewById(R.id.banner_slider1);
        List<Banner> banners=new ArrayList<>();
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.anuncio1));
        banners.add(new DrawableBanner(R.drawable.anuncio2));
        banners.add(new DrawableBanner(R.drawable.anuncio3));
        bannerSlider.setBanners(banners);

        //inicio de menu
       menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu popmenu = new PopupMenu(Main.this, menuButton);
                popmenu.getMenuInflater().inflate(R.menu.popup_menu, popmenu.getMenu());

                popmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu:
                                startActivityForResult(inMenu,1);
                                finish();
                                return true;
                            case R.id.ticket:
                                startActivityForResult(inTicket,2);
                                finish();
                                return true;
                        }
                        return true;
                    }
                });
                    popmenu.show();
            }
        });
       //fin de menu
    }

    public void onClick(View v){
        if(v.getId() == R.id.imageMenu){
            startActivityForResult(inMenu,1);
            finish();
        }else if(v.getId() == R.id.imageTicket){
            startActivityForResult(inTicket,2);
        finish();}
    }

    public void onClickTitulo(View v){
        startActivityForResult(inMain,3);
    }




}
