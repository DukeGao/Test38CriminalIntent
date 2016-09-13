package com.duke.android.test38criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;


import java.util.List;

public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecycleView;
    private CrimeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list,container,false);

        mCrimeRecycleView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //没有LayoutManager，RecyclerView就没法正常工作

        updateUI();
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.getInstance(getActivity());
        //创建CrimeLab的单例
        List<Crime> crimes = crimeLab.getCrimes();
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecycleView.setAdapter(mAdapter);
    }

    /**
     * 创建ViewHolder内部类
     * RecyclerView本身不会创建视图，它创建的是ViewHolder，而ViewHolder引用着一个个itemView
     */
    private class CrimeHolder extends RecyclerView.ViewHolder {

//        public TextView mTitleView;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        private Crime mCrime;

        public void bindCrime(Crime crime){
            mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mDateTextView.setText(mCrime.getmDate().toString());
            mSolvedCheckBox.setChecked(mCrime.isSolved());

        }

        public CrimeHolder(View itemView) {
            super(itemView);

//            mTitleView = (TextView) itemView;
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_solved_check_box);
            //通过保存findViewById（int）方法的成果，能够把宝贵的时间花在onCreateViewHolder上
            //因此，等到调用onBindViewHolder的时候一切已准备就绪
        }
    }

    /**
     * 创建adapter内部类
     * adapter负责创建必要的ViewHolder，绑定ViewHolder至模型层数据
     */
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime> mCrimes;
        private CrimeAdapter(List<Crime> mCrimes){
            this.mCrimes = mCrimes;

        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_crime,parent,false);
            return new CrimeHolder(view);
        }

        /**
         * 把ViewHolder的View视图和模型层数据绑定起来
         * @param holder
         * @param position 索引位置
         */
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
//            holder.mTitleView.setText(crime.getmTitle());
            holder.bindCrime(crime);
        }


        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

}
