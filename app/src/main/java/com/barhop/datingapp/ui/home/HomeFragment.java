package com.barhop.datingapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.barhop.datingapp.DownloadImageTask;
import com.barhop.datingapp.Profile;
import com.barhop.datingapp.R;
import com.barhop.datingapp.databinding.FragmentHomeBinding;

import static com.barhop.datingapp.eloSystem.updateRating;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    // To cycle the profiles, can just use a linked list and visit the next address, if null then display 'out of matches'
    int counter = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button rightButton = root.findViewById(R.id.rightButton);
        Button leftButton = root.findViewById(R.id.leftButton);

        new DownloadImageTask((ImageView) root.findViewById(R.id.profilePicture)).execute(Profile.profiles[counter].photoURL);

        TextView ageText = (TextView)root.findViewById(R.id.age);
        ageText.setText(String.valueOf(Profile.profiles[counter].age));

        homeViewModel.mText.setValue(Profile.profiles[counter].name);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter < Profile.profiles.length - 1) {
                    Profile.profiles[counter].elo = loseElo(homeViewModel.myElo);
                    counter++;
                    homeViewModel.mText.setValue(Profile.profiles[counter].name);
                    new DownloadImageTask((ImageView) root.findViewById(R.id.profilePicture)).execute(Profile.profiles[counter].photoURL);
                    ageText.setText(String.valueOf(Profile.profiles[counter].age));
                    System.out.println(Profile.profiles[counter-1].elo );
                }
                else {
                    counter++;
                    homeViewModel.mText.setValue("No more matches");
                    new DownloadImageTask((ImageView) root.findViewById(R.id.profilePicture)).execute("https://cdn.wallpapersafari.com/84/0/CkrnbA.jpg");
                    ageText.setText(String.valueOf(""));
                }
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(counter < Profile.profiles.length - 1) {
                    Profile.profiles[counter].elo = winElo(homeViewModel.myElo);
                    counter++;
                    homeViewModel.mText.setValue(Profile.profiles[counter].name);
                    new DownloadImageTask((ImageView) root.findViewById(R.id.profilePicture)).execute(Profile.profiles[counter].photoURL);
                    ageText.setText(String.valueOf(Profile.profiles[counter].age));
                    System.out.println(Profile.profiles[counter-1].elo );
                }
                else {
                    counter++;
                    homeViewModel.mText.setValue("No more matches");
                    new DownloadImageTask((ImageView) root.findViewById(R.id.profilePicture)).execute("https://cdn.wallpapersafari.com/84/0/CkrnbA.jpg");
                    ageText.setText(String.valueOf(""));
                }
            }
        });

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    public int loseElo(int otherElo) {
        return updateRating(homeViewModel.myElo, homeViewModel.otherElo, 0);
    }
    public int winElo(int otherElo) {
        return updateRating(homeViewModel.myElo, homeViewModel.otherElo, 1);
    }

   /* @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/
}