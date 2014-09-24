package myexpenses.ng2.com.myexpenses.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.zip.Inflater;

import myexpenses.ng2.com.myexpenses.Data.CategoryDatabase;
import myexpenses.ng2.com.myexpenses.MainActivity;
import myexpenses.ng2.com.myexpenses.R;
import myexpenses.ng2.com.myexpenses.Utils.AddCategoryDialog;

public class CategoriesManagerActivity extends Activity {

    ListView lv;
    Cursor c;
    CategoryDatabase db;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_manager);

        db = new CategoryDatabase(getApplicationContext());

        c = db.getAllCategories();

        lv = (ListView) findViewById(R.id.lvCategories);

        adapter = new MyAdapter(getApplicationContext() , c);

        lv.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.categories_manager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_addCategory) {
            new AddCategoryDialog().show(getFragmentManager() , "Add Category");
        }

        return super.onOptionsItemSelected(item);
    }

    public void refreshList(){
        c.requery();
        adapter.notifyDataSetChanged();

    }

    private class MyAdapter extends CursorAdapter{

        LayoutInflater inflater;

        public MyAdapter(Context context , Cursor c){
            super(context , c);
        }

        @Override
        public View newView(Context context, final Cursor cursor, ViewGroup parent) {
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View newView = inflater.inflate(R.layout.list_item_categories , parent , false);

            ImageView ivIcon = (ImageView) newView.findViewById(R.id.ivIcon);
            TextView tvName = (TextView) newView.findViewById(R.id.tvName);
            ImageButton ibDelete = (ImageButton) newView.findViewById(R.id.ibDelete);

            final String name = cursor.getString(1);
            tvName.setText(name);

            ibDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.deleteCategory(name);
                    cursor.requery();
                    notifyDataSetChanged();
                }
            });


            if(name.equals("Food")){
                ivIcon.setImageResource(R.drawable.food);
            }else if(name.equals("Drinks")){
                ivIcon.setImageResource(R.drawable.drinks);
            }else if(name.equals("Personal")){
                ivIcon.setImageResource(R.drawable.personal);
            }else if(name.equals("Clothing")){
                ivIcon.setImageResource(R.drawable.clothing);
            }


            return newView;
        }

        @Override
        public void bindView(View view, Context context,final Cursor cursor) {
            ImageView ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
            TextView tvName = (TextView) view.findViewById(R.id.tvName);
            ImageButton ibDelete = (ImageButton) view.findViewById(R.id.ibDelete);

            final String name = cursor.getString(1);
            tvName.setText(name);

            ibDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.deleteCategory(name);
                    cursor.requery();
                    notifyDataSetChanged();
                }
            });

            if(name.equals("Food")){
                ivIcon.setImageResource(R.drawable.food);
            }else if(name.equals("Drinks")){
                ivIcon.setImageResource(R.drawable.drinks);
            }else if(name.equals("Personal")){
                ivIcon.setImageResource(R.drawable.personal);
            }else if(name.equals("Clothing")){
                ivIcon.setImageResource(R.drawable.clothing);
            }
        }


    }

}
