package se.slashat.slashapp.adapter;

import se.slashat.slashapp.R;
import se.slashat.slashapp.viewmodel.SectionViewModel;
import se.slashat.slashapp.viewmodel.ViewModelBase;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public abstract class AbstractArrayAdapter<T extends ViewModelBase<?>> extends ArrayAdapter<ViewModelBase<?>> {

	protected int layoutResourceId;
	protected int sectionLayoutResourceId;
	protected Context context;
	protected T[] data;

	public AbstractArrayAdapter(Context context, int layoutResourceId, int sectionLayoutResourceId, T[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.sectionLayoutResourceId = sectionLayoutResourceId;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, final ViewGroup parent) {
		View row = convertView;
		Holder holder = null;
		final T t = data[position];
		//if (t instanceof ViewModelBase) {
			boolean isSection = false;
			
			if (t instanceof SectionViewModel){
				isSection = true;
			}
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			if (isSection) {
				if (row == null || !(row.getTag() instanceof SectionHolder) ) {
					row = inflater.inflate(sectionLayoutResourceId, parent, false);
				}
				holder = getSectionHolder(row);
			} else {
				if (row == null || (row.getTag() instanceof SectionHolder)) {
					row = inflater.inflate(layoutResourceId, parent, false);
				}
				holder = createHolder(row);
			}
			row.setTag(holder);
		//}

		if (isClickable()) {
			row.setOnClickListener(createOnClickListener(t));
		} else {
			row.setClickable(false);
		}
		if (holder != null) {
			if (holder instanceof SectionHolder) {
				setDataOnSectionHolder(holder, (SectionViewModel) t);
			} else {
				setDataOnHolder(holder, t);
			}
		}

        if (!t.isAnimationShown()) {
            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.push_up_in);

            animation.setDuration(500);
            row.startAnimation(animation);
            animation = null;
            t.setAnimationShown(true);
        }

		return row;
	}

	private void setDataOnSectionHolder(Holder holder, SectionViewModel t) {
		SectionHolder h = (SectionHolder) holder;
		h.titleTextView.setText(((SectionViewModel) t).getModel().getSectionName());

	}

	/**
	 * Create a holder for this row. The holder is following the Android holder
	 * pattern for UI caching
	 * 
	 * @param row
	 * @return
	 */
	public abstract Holder createHolder(View row);

	public Holder getSectionHolder(View row) {
		SectionHolder sectionHolder = new SectionHolder();
		sectionHolder.titleTextView = (TextView) row.findViewById(R.id.sectiontitle);
		return sectionHolder;
	}

	/**
	 * Returns an OnClickListener that will be executed when the user clicks on
	 * this row. It takes the generic type of the class as argument (the
	 * datamodel of the clicked row)
	 * 
	 * @param t
	 * @return
	 */

	public abstract OnClickListener createOnClickListener(T t);

	/**
	 * Is the row clickable or not
	 * 
	 * @return
	 */
	public abstract boolean isClickable();

	/**
	 * Set all the data on the holder based on the datamodel T
	 * 
	 * @param holder
	 * @param t
	 */
	public abstract void setDataOnHolder(Holder holder, T t);

	static class Holder {
	}

	static class SectionHolder extends Holder {
		private TextView titleTextView;
	}

}
