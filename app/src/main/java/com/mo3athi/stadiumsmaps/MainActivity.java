package com.mo3athi.stadiumsmaps;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

  RecyclerView recyclerView;
  ArrayList<StadiumModel> arStadiums;
  MyAdapter adapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setLogo(R.drawable.ic_launcher_background);
    //english
    if (Locale.getDefault().getDisplayLanguage().toString().equals("English")) {
      arStadiums = new ArrayList<>();

      arStadiums.add(new StadiumModel("king الملك عبد الله الثاني", "8:00 - 3:00",
          "15 Jd", "31.928057", "35.953257"));

      arStadiums.add(new StadiumModel("ستاد عمان الدولي", "10:00 - 5:00",
          "20 Jd", "31.9851496", "35.9006254"));

      arStadiums.add(new StadiumModel("ستاد الحسن", "9:00 - 2:00",
          "5 Jd", "32.537694", "35.860264"));

      arStadiums.add(new StadiumModel("ستاد الأمير محمد", "10:00 - 5:00",
          "10 Jd", "32.099945", "36.112919"));

      arStadiums.add(new StadiumModel("ستاد البتراء", "10:00 - 5:00",
          "8 Jd", "31.981737", "35.903236"));

      arStadiums.add(new StadiumModel("ملعب الامير علي", "10:00 - 5:00",
          "12 Jd", "32.330303", "36.242244"));

      recyclerView = findViewById(R.id.recyclerView);

      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      adapter = new MyAdapter(arStadiums);
      recyclerView.setAdapter(adapter);

      //arabic
    } else if (Locale.getDefault().getDisplayLanguage().toString().equals("العربية")) {
      arStadiums = new ArrayList<>();

      arStadiums.add(new StadiumModel("ستاد الملك عبد الله الثاني", "8:00 - 3:00",
          "15 Jd", "31.928057", "35.953257"));

      arStadiums.add(new StadiumModel("ستاد عمان الدولي", "10:00 - 5:00",
          "20 Jd", "31.9851496", "35.9006254"));

      arStadiums.add(new StadiumModel("ستاد الحسن", "9:00 - 2:00",
          "5 Jd", "32.537694", "35.860264"));

      arStadiums.add(new StadiumModel("ستاد الأمير محمد", "10:00 - 5:00",
          "10 Jd", "32.099945", "36.112919"));

      arStadiums.add(new StadiumModel("ستاد البتراء", "10:00 - 5:00",
          "8 Jd", "31.981737", "35.903236"));

      arStadiums.add(new StadiumModel("ملعب الامير علي", "10:00 - 5:00",
          "12 Jd", "32.330303", "36.242244"));

      recyclerView = findViewById(R.id.recyclerView);

      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      adapter = new MyAdapter(arStadiums);
      recyclerView.setAdapter(adapter);

    }

//    arStadiums = new ArrayList<>();
//
//    arStadiums.add(new StadiumModel("ستاد الملك عبد الله الثاني", "8:00 - 3:00",
//        "15 Jd", "31.928057", "35.953257"));
//
//    arStadiums.add(new StadiumModel("ستاد عمان الدولي", "10:00 - 5:00",
//        "20 Jd", "31.9851496", "35.9006254"));
//
//    arStadiums.add(new StadiumModel("ستاد الحسن", "9:00 - 2:00",
//        "5 Jd", "32.537694", "35.860264"));
//
//    arStadiums.add(new StadiumModel("ستاد الأمير محمد", "10:00 - 5:00",
//        "10 Jd", "32.099945", "36.112919"));
//
//    arStadiums.add(new StadiumModel("ستاد البتراء", "10:00 - 5:00",
//        "8 Jd", "31.981737", "35.903236"));
//
//    arStadiums.add(new StadiumModel("ملعب الامير علي", "10:00 - 5:00",
//        "12 Jd", "32.330303", "36.242244"));
//
//    recyclerView = findViewById(R.id.recyclerView);
//
//    recyclerView.setHasFixedSize(true);
//    recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    adapter = new MyAdapter(arStadiums);
//    recyclerView.setAdapter(adapter);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_main, menu);

    MenuItem search = menu.findItem(R.id.search);
    SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
    search(searchView);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    return super.onOptionsItemSelected(item);
  }

  private void search(SearchView searchView) {

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {

        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {

        adapter.getFilter().filter(newText);
        if (adapter != null) {
          adapter.getFilter().filter(newText);
        }

        return true;
      }
    });

  }
}