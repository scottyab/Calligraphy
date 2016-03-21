package uk.co.chrisjenx.calligraphy.sample;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_layout)
    protected CollapsingToolbarLayout toolbarLayout;

    @Bind(R.id.fab)
    protected FloatingActionButton fab;

    @Bind(R.id.toolbar_image)
    protected ImageView toolbarImage;

    @Bind(R.id.toolbar_subtitle)
    protected TextView subtitle;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collasping_toolbar_layout);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        toolbarImage.setImageResource(R.drawable.sample_header_image);
        toolbarLayout.setTitle("Calligraphy");

        Typeface tf = TypefaceUtils.load(getAssets(), "fonts/Oswald-Stencbab.ttf");
        toolbarLayout.setCollapsedTitleTypeface(tf);
        toolbarLayout.setExpandedTitleTypeface(tf);

        subtitle.setText("TextView within the CollapsingToolbarLayout");

        // Inject pragmatically
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, PlaceholderFragment.getInstance())
                .commit();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
