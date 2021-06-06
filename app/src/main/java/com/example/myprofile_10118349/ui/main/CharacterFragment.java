/*
05 JUNI 2021
10118349
Dedi firmansyah
IF8
*/
package com.example.myprofile_10118349.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myprofile_10118349.R;
import com.example.myprofile_10118349.dao.CharacterDAO;
import com.example.myprofile_10118349.database.table.TableCharacter;
import com.example.myprofile_10118349.model.Character;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterFragment extends Fragment {

    EditText edtName, edtRace;
    RadioGroup rgSex;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CharacterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterFragment newInstance(String param1, String param2) {
        CharacterFragment fragment = new CharacterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character, container, false);
        //find views
        edtName = (EditText)view.findViewById(R.id.edtName);
        edtRace = (EditText)view.findViewById(R.id.edtRace);
        rgSex = (RadioGroup)view.findViewById(R.id.rgSex);
        if(getArguments() != null){
            recoveyCharacter();
        }
        setHasOptionsMenu(true);
        return view;
    }

    private void recoveyCharacter(){
        Bundle args = getArguments();
        CharacterDAO characterDAO = new CharacterDAO(getActivity());
        ArrayList<Character> characters = characterDAO.select(TableCharacter.FIELD_ID + " = ?", new String[]{String.valueOf(args.getInt(TableCharacter.FIELD_ID))});
        if(characters.size() > 0){
            Character character = characters.get(0);
            edtName.setText(character.getName());
            edtRace.setText(character.getRace());
            if(character.getSex().equals("M")){
                RadioButton rb = (RadioButton)rgSex.findViewById(R.id.rbSexMale);
                rb.setChecked(true);
            }else{
                RadioButton rb = (RadioButton)rgSex.findViewById(R.id.rbSexFemale);
                rb.setChecked(true);
            }
        }
    }
    private void saveCharacter(){
        CharacterDAO characterDAO = new CharacterDAO(getActivity());
        if(checkFields()) {
            Character character = new Character();
            character.setName(edtName.getText().toString().trim());
            character.setRace(edtRace.getText().toString().trim());
            switch (rgSex.getCheckedRadioButtonId()){
                case R.id.rbSexMale:
                    character.setSex("M");
                    break;
                case R.id.rbSexFemale:
                    character.setSex("F");
                    break;
            }
            if(getArguments() != null){
                character.setId(getArguments().getInt(TableCharacter.FIELD_ID));
                characterDAO.update(character);
            }else{
                characterDAO.insert(character);
            }
            popThisFragment();
        }
    }
    private void deleteCharacter(){
        CharacterDAO characterDAO = new CharacterDAO(getActivity());
        characterDAO.delete(getArguments().getInt(TableCharacter.FIELD_ID));
        popThisFragment();
    }
    private boolean checkFields(){
        String error = "";
        if(edtName.getText().toString().trim().length() < 1){
            error += "- Name required\n";
        }
        if(edtRace.getText().toString().trim().length() < 1){
            error += "- Race required\n";
        }
        switch (rgSex.getCheckedRadioButtonId()){
            case R.id.rbSexMale:
            case R.id.rbSexFemale:
        }
        if(error.equals("")){
            return true;
        }
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
        return false;
    }
    private void popThisFragment(){
        getActivity().getSupportFragmentManager().popBackStack();
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_carakter, menu);
        if(getArguments() == null){
            menu.findItem(R.id.action_delete).setVisible(false);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                saveCharacter();
                break;
            case R.id.action_delete:
                deleteCharacter();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}