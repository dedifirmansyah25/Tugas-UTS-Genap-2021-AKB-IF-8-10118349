/*
04 JUNI 2021
10118349
Dedi firmansyah
IF8
*/
package com.example.myprofile_10118349.ui.main;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myprofile_10118349.R;
import com.example.myprofile_10118349.dao.CharacterDAO;
import com.example.myprofile_10118349.database.table.TableCharacter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.myprofile_10118349.model.Character;

import java.util.ArrayList;

public class CatatanFragment extends Fragment {

    FloatingActionButton actionButton;
    ListView listView;


    ArrayList<Character> characters = new ArrayList<>();


    public CatatanFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catatan, container, false);


        //find views
        actionButton = (FloatingActionButton) view.findViewById(R.id.actionButton);
        listView = (ListView) view.findViewById(R.id.listView);


        //start listeners
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.characterFragment);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Character character = characters.get(position);
                Bundle bundle = new Bundle();
                bundle.putInt(TableCharacter.FIELD_ID, character.getId());
                replaceFragment(bundle);
            }
        });


        return view;
    }


    @Override
    public void onResume() {
        //populate list
        CharacterDAO characterDAO = new CharacterDAO(getActivity());
        characters = characterDAO.select(null, null);
        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, characters));
        super.onResume();
    }


    private void replaceFragment(Bundle args) {
        CatatanFragment fragment = new CatatanFragment();
        if (args != null) {
            fragment.setArguments(args);
        }
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(this.getClass().getName())
                .replace(R.id.nav_view, fragment)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private CatatanViewModel mViewModel;

    public static CatatanFragment newInstance() { return new CatatanFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CatatanViewModel.class);
        // TODO: Use the ViewModel
    }

}



