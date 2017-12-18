package hipo.prop.app.axel.com.proyecto;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class Menu extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener{
    ViewPager vp;
    TabLayout tabLayout;
    ImageButton menuButton;
    Intent inTicket, inMenu, inMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuButton = findViewById(R.id.menuButton);

        inTicket = new Intent(this, Ticket.class);
        inMenu = new Intent(this,Menu.class);
        inMain = new Intent(this,Main.class);

        //inicio de menu
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu popmenu = new PopupMenu(Menu.this, menuButton);
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //VIEWPAGER
        vp= (ViewPager) findViewById(R.id.viewp);
        this.addPages();
        //TABLAYOUT
        tabLayout= findViewById(R.id.tablay);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(this);
    }
    private void addPages()
    {
        MyPageAdapter pagerAdapter=new MyPageAdapter(this.getSupportFragmentManager());
        pagerAdapter.addFragment(new TacosFragment());
        pagerAdapter.addFragment(new TortasFragment());
        pagerAdapter.addFragment(new DrinksFragment());
        pagerAdapter.addFragment(new DessertsFragment());
        //SET ADAPTER TO VP
        vp.setAdapter(pagerAdapter);
    }
    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(tab.getPosition());
    }
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }
    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void onClickTitulo(View v){
        startActivityForResult(inMain,3);
    }

}
