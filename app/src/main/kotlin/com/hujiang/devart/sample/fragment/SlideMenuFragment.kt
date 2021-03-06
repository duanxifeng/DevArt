package com.hujiang.devart.sample.fragment

import android.os.Bundle
import android.preference.Preference
import android.view.Menu
import com.hujiang.devart.base.BasePreferenceFragment
import com.hujiang.devart.sample.MainActivity
import com.hujiang.devart.sample.R
import com.hujiang.devart.sample.SlideActivity

/**
 * Created by rarnu on 3/25/16.
 */
class SlideMenuFragment: BasePreferenceFragment(), Preference.OnPreferenceClickListener {

    private var _pItem1: Preference? = null
    private var _pItem2: Preference? = null
    private var _pItem3: Preference? = null

    override fun getBarTitle(): Int = R.string.slidemenu_name

    override fun getBarTitleWithPath(): Int = R.string.slidemenu_name

    override fun getCustomTitle(): String? = null

    override fun initComponents() {
        _pItem1 = findPreference(getString(R.string.menuid_item_1))
        _pItem2 = findPreference(getString(R.string.menuid_item_2))
        _pItem3 = findPreference(getString(R.string.menuid_item_3))
    }

    override fun initEvents() {
        _pItem1?.onPreferenceClickListener = this
        _pItem2?.onPreferenceClickListener = this
        _pItem3?.onPreferenceClickListener = this
    }

    override fun initLogic() { }

    override fun getFragmentLayoutResId(): Int = R.xml.menu_slide

    override fun getMainActivityName(): String? = MainActivity::class.java.name

    override fun initMenu(menu: Menu?) { }

    override fun onGetNewArguments(bn: Bundle?) { }

    override fun getFragmentState(): Bundle? = null

    override fun onPreferenceClick(preference: Preference?): Boolean {
        val text = preference?.title.toString()
        val bn = Bundle()
        bn.putString("text", text)
        (activity as SlideActivity).contentFragment?.setNewArguments(bn)
        (activity as SlideActivity).getSlidingMenu()?.toggle()
        return true
    }
}