package id.android.sucacocustomerservice.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.android.sucacocustomerservice.R;
import id.android.sucacocustomerservice.model.VisitorModel;

/**
 * Created by sysware-p2 on 4/24/2019.
 */

public class VisitorAdapter extends RecyclerView.Adapter<VisitorAdapter.MahasiswaViewHolder> {


    private ArrayList<VisitorModel> dataList;

    public VisitorAdapter(ArrayList<VisitorModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_visitor, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MahasiswaViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_name_visitor);
        }
    }
}
