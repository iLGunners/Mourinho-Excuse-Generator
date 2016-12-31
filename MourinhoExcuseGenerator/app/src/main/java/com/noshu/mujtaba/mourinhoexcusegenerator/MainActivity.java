package com.noshu.mujtaba.mourinhoexcusegenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView excuseTextView;
    String excusePartOne, excusePartTwo, excusePartThree, finalExcuse;
    String[] exArrayPartOne, exArrayPartTwo, exArrayPartThree;
    int clickCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        this.populateStringArrays();

        this.excuseTextView = (TextView) findViewById(R.id.ExcuseTextView);

        this.excuseTextView.setText("I have nothing to say!");

        this.showAdvert();
    }

    public void populateStringArrays() {
        this.exArrayPartOne  = new String[]{
                "the Referee", "the Fans",
                "Terry", "Hazard",
                "Arsène", "Fergie",
                "the specialist in failure", "the Bus",
                "the Pitch", "Eva",
                "the FA", "the Media",
                "the Ball-Boy", "Abramovich",
                "Stones", "Pogba",
                "#Pogback", "Depay's tattoos",
                "Xhaka"
        };
        this.exArrayPartTwo  = new String[]{
                "was distracted by", "hurt",
                "was intimidated by", "is conspiring against",
                "doesn't understand", "disrupted",
                "didn't pay attention to", "Pogboomed",
                "XhakaBoomed"
        };
        this.exArrayPartThree  = new String[]{
                "my EGO", "my instruction",
                "my feelings", "ME",
                "the team", "Costa",
                "Hazard's form", "Hazard's Penalty",
                "Fàbregas' legs", "my 1st spell at this team",
                "huge sums of money", "United",
                "Pogba's form"
        };
    }

    public String getExcuse() {
        this.excusePartOne = this.exArrayPartOne[this.getRandomLocation(this.exArrayPartOne.length)];
        //this.excusePartOne = this.exArrayPartOne[this.exArrayPartOne.length-1];
        this.excusePartTwo = this.exArrayPartTwo[this.getRandomLocation(this.exArrayPartTwo.length)];
        //this.excusePartTwo = this.exArrayPartTwo[this.exArrayPartTwo.length-1];
        this.excusePartThree = this.exArrayPartThree[this.getRandomLocation(this.exArrayPartThree.length)];
        //this.excusePartThree = this.exArrayPartThree[this.exArrayPartThree.length-1];

        return this.finalExcuse = this.excusePartOne + " " + this.excusePartTwo + " " + this.excusePartThree + "!";
    }

    public int getRandomLocation(int max) {
        Random rand = new Random();
        int min = 0;
        max = max -1;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void genClicked(View view) {
        this.excuseTextView.setText(this.getExcuse());

        this.clickCount = this.clickCount+1;
        if(this.clickCount > 9)
            this.showAdvert();
    }

    public void showAdvert() {
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
