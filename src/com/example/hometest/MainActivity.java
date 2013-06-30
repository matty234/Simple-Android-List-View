package com.example.hometest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	//You must always initialise an ArrayList before using it.
	ArrayList<String> listArrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * The following array will appear in the final listview. In this
		 * example we are declaring the different Ice Cream flavours. I have
		 * used a ArrayList because it is easy to add Strings later using
		 * .add().
		 */
		listArrayList.add("Chocolate");
		listArrayList.add("Strawberry");
		listArrayList.add("Vanilla");
		listArrayList.add("Rum and Raisin");

		/*
		 * Next, we find the ListView from the XML file using 'findViewById()'
		 * In the this example, the ID of the list is 'IceCreamList'.
		 */
		ListView lv = (ListView) findViewById(R.id.IceCreamList);

		/*
		 * Now we add an adapter. The adapter will read the list (listArrayList)
		 * and add the ListView items. We also declare the style of the ListView
		 * here (android.R.layout.simple_list_item_1).
		 */
		lv.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listArrayList));

		/*
		 * The 'setOnItemClickListener' adds a listener that uses the
		 * 'onItemClick' method when an item in the listview is clicked on.
		 */
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {
				/*
				 * The following lines (up to dialog.show()) create a dialog.
				 * The Dialog has a title 'Ice Cream selected', a body of 'You
				 * have choose a ... flavoured Ice Cream' and an 'Ok' dismiss
				 * button. Also, when the 'Ok' button is clicked. the
				 * 'OkOnClickListener' is called.
				 */
				Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("Ice Cream Selected");
				builder.setMessage("You have choosen a "
						+ ((TextView) view).getText() + " flavoured Ice Cream.");
				builder.setCancelable(false);
				builder.setNeutralButton("Ok", new OkOnClickListener());
				AlertDialog dialog = builder.create();
				dialog.show();
				// ((TextView) view).getText() gets the content of the selected
				// TextView

			}

			final class OkOnClickListener implements
					DialogInterface.OnClickListener {
				public void onClick(DialogInterface dialog, int which) {
					/*
					 * The 'OkOnClickListener' calls a 'println'. This prints a
					 * message to the log ('The dialog has been dismissed').
					 */
					System.out.println("The dialog has been dismissed");
				}
			}
		});
	}

}
