package com.tutorials.hp.searchbarrecyclerview;

import android.widget.Filter;

import java.util.ArrayList;

/**
 - Our FilterHelper class.
 - Derives from android.widget.filter.
 - We perform filtering here and publish results back to the adapter which is then refreshed.
 */

public class FilterHelper extends Filter {
    static ArrayList<String> currentList;
    static MyAdapter adapter;

    public static FilterHelper newInstance(ArrayList<String> currentList, MyAdapter adapter) {
        FilterHelper.adapter=adapter;
        FilterHelper.currentList=currentList;
        return new FilterHelper();
    }

    /*
    - Perform actual filtering.
     */
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults=new FilterResults();

        if(constraint != null && constraint.length()>0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();

            //HOLD FILTERS WE FIND
            ArrayList<String> foundFilters=new ArrayList<>();

            String galaxy;

            //ITERATE CURRENT LIST
            for (int i=0;i<currentList.size();i++)
            {
                galaxy= currentList.get(i);

                //SEARCH
                if(galaxy.toUpperCase().contains(constraint))
                {
                    //ADD IF FOUND
                    foundFilters.add(galaxy);
                }
            }

            //SET RESULTS TO FILTER LIST
            filterResults.count=foundFilters.size();
            filterResults.values=foundFilters;
        }else
        {
            //NO ITEM FOUND.LIST REMAINS INTACT
            filterResults.count=currentList.size();
            filterResults.values=currentList;
        }

        //RETURN RESULTS
        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        adapter.setGalaxies((ArrayList<String>) filterResults.values);
        adapter.notifyDataSetChanged();
    }
}
