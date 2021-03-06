package com.hql.gree2.easternpioneerbus;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hql.gree2.easternpioneerbus.adapter.BusStopAdapter;
import com.hql.gree2.easternpioneerbus.dao.BusStop;
import com.hql.gree2.easternpioneerbus.manager.DatabaseManager;
import com.hql.gree2.easternpioneerbus.manager.IDatabaseManager;
import com.umeng.analytics.MobclickAgent;

import java.util.List;

public class BusStopFragment extends Fragment implements AdapterView.OnItemClickListener {

    private BusStopAdapter adapter;

    public BusStopFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bus_stop, container, false);

        // init database & busline
        IDatabaseManager databaseManager = new DatabaseManager(getActivity());
        long busLineId = getArguments().getLong("BusLineId");
        List<BusStop> busStops = databaseManager.listBusStops(busLineId);

        adapter = new BusStopAdapter(getActivity(), busStops);
        ListView busStopListView = (ListView) rootView.findViewById(R.id.stops_list);
        busStopListView.setAdapter(adapter);
        busStopListView.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        view.setSelected(true);
        Intent intent = new Intent(getActivity().getApplicationContext(),
                BusStopDetailActivity.class);
        intent.putExtra("BusStopId", ((BusStop) adapter.getItem(position)).getId());
        startActivity(intent);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("MainActivity");
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("MainActivity");
    }

}
