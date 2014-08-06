package se.slashat.slashapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import se.slashat.slashapp.R;
import se.slashat.slashapp.viewmodel.HighFiverViewModel;
import se.slashat.slashapp.viewmodel.ViewModelBase;

/**
 * Created by nicklas on 10/1/13.
 */
public class MyHighFiversArrayAdapter extends AbstractArrayAdapter<ViewModelBase<?>>{

    public MyHighFiversArrayAdapter(Context context, int layoutResourceId, ViewModelBase[] data) {
        super(context, layoutResourceId, R.layout.section, data);
    }

    public static class MyHighFiversHolder extends ImageAsyncHolder {
        TextView name;
        TextView username;
    }

    @Override
    public Holder createHolder(View row) {
        MyHighFiversHolder myHighFiversHolder = new MyHighFiversHolder();
        myHighFiversHolder.name = (TextView) row.findViewById(R.id.txtName);
        myHighFiversHolder.username = (TextView) row.findViewById(R.id.title);
        myHighFiversHolder.imageThumb = (ImageView) row.findViewById(R.id.imgIcon);
        myHighFiversHolder.progressBar = (ProgressBar) row.findViewById(R.id.imageviewprogress);

        return myHighFiversHolder;
    }

    @Override
    public View.OnClickListener createOnClickListener(ViewModelBase highFiverViewModel) {
        return null;
    }

    @Override
    public boolean isClickable() {
        return false;
    }

    @Override
    public void setDataOnHolder(Holder holder, ViewModelBase highFiverViewModel, int position) {
        final MyHighFiversHolder hi5Holder = (MyHighFiversHolder) holder;
        HighFiverViewModel vm = (HighFiverViewModel) highFiverViewModel;

        hi5Holder.name.setText(vm.getModel().getUsername());
        hi5Holder.username.setText("");

        if (vm.getModel().getPicture() != null){

            hi5Holder.progressBar.setVisibility(View.VISIBLE);
            Picasso.with(hi5Holder.imageThumb.getContext()).load(vm.getModel().getPicture().toString()).into(hi5Holder.imageThumb, new com.squareup.picasso.Callback() {
                @Override
                public void onSuccess() {
                    hi5Holder.progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError() {
                    hi5Holder.progressBar.setVisibility(View.GONE);
                }
            });
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
