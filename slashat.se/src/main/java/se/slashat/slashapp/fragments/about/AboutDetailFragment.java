package se.slashat.slashapp.fragments.about;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import se.slashat.slashapp.R;
import se.slashat.slashapp.model.Personal;

/**
 * Created by nicklas on 6/19/13.
 */
public class AboutDetailFragment extends Fragment {


    private Personal person;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.about_detail, null);

        if (person != null) {
            setText(view.findViewById(R.id.name), person.getName());
            setText(view.findViewById(R.id.title), person.getTitle());
            setText(view.findViewById(R.id.bio), person.getBio());
            setImage(view.findViewById(R.id.photo), person.getImg());
            setHomepageClickListener(person,view.findViewById(R.id.browser));
            setEmailClickListener(person,view.findViewById(R.id.email));
            setTwitterClickListener(person,view.findViewById(R.id.twitter));

        }
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey("person")) {
            person = (Personal) getArguments().getSerializable("person");
        }
    }


    private void setText(View view, String text) {
        ((TextView) view).setText(text);
    }

    private void setImage(View view, int imageResource) {
        ((ImageView) view).setImageResource(imageResource);
    }


    private void setHomepageClickListener(final Personal t, View imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowserIntent(t);
            }
        });
    }

    private void setEmailClickListener(final Personal t, View imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmailIntent(t);
            }
        });
    }

    private void setTwitterClickListener(final Personal t, View imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwitterIntent(t);
            }
        });
    }

    private void openTwitterIntent(final Personal t) {
        try {
            // TODO: Can all twitter clients be targeted?
            // Looks like every different client has it's own way to open it
            // correctly. Tried with twitter:// but got errors that no
            // application was found.

            getActivity().getPackageManager()
                    .getPackageInfo("com.twitter.android", 0);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setClassName("com.twitter.android",
                    "com.twitter.android.ProfileActivity");
            intent.putExtra("screen_name", t.getTwitter());
            getActivity().startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            // Fall back to browser
            getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri
                    .parse("https://twitter.com/" + t.getTwitter())));
        }
    }

    private void openEmailIntent(final Personal t) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[]{t.getEmail()});
        // TODO: The chooser shows more than just email clients.
        getActivity().startActivity(Intent.createChooser(intent,
                "Välj applikation att skicka mail med"));
    }

    private void openBrowserIntent(Personal t) {
        getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(t
                .getHomepage())));
    }


}
