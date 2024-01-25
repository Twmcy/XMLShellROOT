package com.projectkr.shell

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.omarea.common.shared.FilePathResolver;
import com.omarea.common.ui.ProgressBarDialog;
import com.omarea.krscript.config.PageConfigReader;
import com.omarea.krscript.config.PageConfigSh;
import com.projectkr.shell.FloatMonitor;
import com.omarea.krscript.model.*;
import com.omarea.krscript.ui.ActionListFragment;
import com.omarea.krscript.ui.ParamsFileChooserRender;
import com.projectkr.shell.ui.TabIconHelper;
import com.projectkr.shell.permissions.CheckRootStatus;
import com.omarea.common.ui.DialogHelper;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.provider.Settings;
import net.khirr.android.privacypolicy.PrivacyPolicyDialog;
import com.projectkr.shell.Update;
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val progressBarDialog = ProgressBarDialog(this)
    private var handler = Handler()
    private var krScriptConfig = KrScriptConfig()

    private fun checkPermission(permission: String): Boolean = PermissionChecker.checkSelfPermission(this, permission) == PermissionChecker.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
    // 因为，所以，还是所以，有些小白不会写也不会编译，可以在软件中加入，把//去了就可以用了，把SHA1转换base64
        //val appcenterStatus = AppCenterStatus(this)
      //  val signCode = String(Base64.decode("你的base64签名))
       // val signCheck = SignCheck(this, signCode)
        Update().checkUpdate(this)
      //  if (appcenterStatus.getAppCenterStatus() && signCheck.check()) {
          //  AppCenter.start(application, "可以不用", Analytics::class.java, Crashes::class.java)
     //   } else {
          //  Log.d("AppCenter", "AppCenter is disabled")
   //     }
        super.onCreate(savedInstanceState)
        ThemeModeState.switchTheme(this)
        setContentView(R.layout.activity_main)

        //supportActionBar!!.elevation = 0f
        dialog.title = getString(R.string.termsOfServiceTitle)
        dialog.termsOfServiceSubtitle = getString(R.string.termsOfServiceSubtitle)
        dialog.addPoliceLine(getString(R.string.PoliceLine1))
        dialog.addPoliceLine(getString(R.string.PoliceLine2))
        dialog.cancelText = getString(R.string.dialog_cancelText)
        dialog.acceptText = getString(R.string.dialog_acceptText)
        dialog.acceptButtonColor = ContextCompat.getColor(this, R.color.colorAccent)
        dialog.europeOnly = false
        dialog.show()
        
        //supportActionBar!!.elevation = 0f
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        setTitle(R.string.app_name)

        krScriptConfig = KrScriptConfig()


        main_tabhost.setup()
        val tabIconHelper = TabIconHelper(main_tabhost, this)
        if (CheckRootStatus.lastCheckResult && krScriptConfig.allowHomePage) {
            tabIconHelper.newTabSpec(getString(R.string.tab_home), getDrawable(R.drawable.tab_home)!!, R.id.main_tabhost_cpu)
        } else {
            main_tabhost_cpu.visibility = View.GONE
        }
        main_tabhost.setOnTabChangedListener {
            tabIconHelper.updateHighlight()
        }

        progressBarDialog.showDialog(getString(R.string.please_wait))
        Thread(Runnable {
            val page2Config = krScriptConfig.pageListConfig
            val favoritesConfig = krScriptConfig.favoriteConfig
            val favoriteConfig1 = krScriptConfig.favoriteConfig1
            val favoriteConfig2 = krScriptConfig.favoriteConfig2
            val favoriteConfig3 = krScriptConfig.favoriteConfig3
            val favoriteConfig4 = krScriptConfig.favoriteConfig4
            val favoriteConfig5 = krScriptConfig.favoriteConfig5
            val favoriteConfig6 = krScriptConfig.favoriteConfig6
            val favoriteConfig7 = krScriptConfig.favoriteConfig7
            val favoriteConfig8 = krScriptConfig.favoriteConfig8
            val favoriteConfig9 = krScriptConfig.favoriteConfig9
            val favoriteConfig10 = krScriptConfig.favoriteConfig10
            val favoriteConfig11 = krScriptConfig.favoriteConfig11
            val favoriteConfig12 = krScriptConfig.favoriteConfig12
            val favoriteConfig13 = krScriptConfig.favoriteConfig13
            val favoriteConfig14 = krScriptConfig.favoriteConfig14
            val favoriteConfig15 = krScriptConfig.favoriteConfig15
            val favoriteConfig16 = krScriptConfig.favoriteConfig16
            val favoriteConfig17 = krScriptConfig.favoriteConfig17
            val favoriteConfig18 = krScriptConfig.favoriteConfig18
            val favoriteConfig19 = krScriptConfig.favoriteConfig19
            val favoriteConfig20 = krScriptConfig.favoriteConfig20
            val favoriteConfig21 = krScriptConfig.favoriteConfig21

            val pages = getItems(page2Config)
            val favorites = getItems(favoritesConfig)
            val favorites1 = getItems(favoriteConfig1)
            val favorites2 = getItems(favoriteConfig2)
            val favorites3 = getItems(favoriteConfig3)
            val favorites4 = getItems(favoriteConfig4)
            val favorites5 = getItems(favoriteConfig5)
            val favorites6 = getItems(favoriteConfig6)
            val favorites7 = getItems(favoriteConfig7)
            val favorites8 = getItems(favoriteConfig8)
            val favorites9 = getItems(favoriteConfig9)
            val favorites10 = getItems(favoriteConfig10)
            val favorites11 = getItems(favoriteConfig11)
            val favorites12 = getItems(favoriteConfig12)
            val favorites13 = getItems(favoriteConfig13)
            val favorites14 = getItems(favoriteConfig14)
            val favorites15 = getItems(favoriteConfig15)
            val favorites16 = getItems(favoriteConfig16)
            val favorites17 = getItems(favoriteConfig17)
            val favorites18 = getItems(favoriteConfig18)
            val favorites19 = getItems(favoriteConfig19)
            val favorites20 = getItems(favoriteConfig20)
            val favorites21 = getItems(favoriteConfig21)
            handler.post {
                progressBarDialog.hideDialog()

                if (favorites != null && favorites.size > 0) {
                    updateFavoritesTab(favorites, favoritesConfig)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites), ContextCompat.getDrawable(this, R.drawable.tab_favorites)!!, R.id.main_tabhost_2)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (pages != null && pages.size > 0) {
                    updateMoreTab(pages, page2Config)
                    tabIconHelper.newTabSpec(getString(R.string.tab_pages), ContextCompat.getDrawable(this, R.drawable.tab_pages)!!, R.id.main_tabhost_3)
                } else {
                    main_tabhost_3.visibility = View.GONE
                }
                
                
                if (favorites1 != null && favorites1.size > 0) {
                    updatefavorites1Tab(favorites1, favoriteConfig1)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites1), ContextCompat.getDrawable(this, R.drawable.tab_favorites1)!!, R.id.main_tabhost_3)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites2 != null && favorites2.size > 0) {
                    updatefavorites2Tab(favorites2, favoriteConfig2)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites2), ContextCompat.getDrawable(this, R.drawable.tab_favorites2)!!, R.id.main_tabhost_4)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites3 != null && favorites3.size > 0) {
                    updatefavorites3Tab(favorites3, favoriteConfig3)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites3), ContextCompat.getDrawable(this, R.drawable.tab_favorites3)!!, R.id.main_tabhost_5)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites4 != null && favorites4.size > 0) {
                    updatefavorites4Tab(favorites4, favoriteConfig4)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites4), ContextCompat.getDrawable(this, R.drawable.tab_favorites4)!!, R.id.main_tabhost_6)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites5 != null && favorites5.size > 0) {
                    updatefavorites5Tab(favorites5, favoriteConfig5)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites5), ContextCompat.getDrawable(this, R.drawable.tab_favorites5)!!, R.id.main_tabhost_7)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites6 != null && favorites6.size > 0) {
                    updatefavorites6Tab(favorites6, favoriteConfig6)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites6), ContextCompat.getDrawable(this, R.drawable.tab_favorites6)!!, R.id.main_tabhost_8)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites7 != null && favorites7.size > 0) {
                    updatefavorites7Tab(favorites7, favoriteConfig7)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites7), ContextCompat.getDrawable(this, R.drawable.tab_favorites7)!!, R.id.main_tabhost_9)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites8 != null && favorites8.size > 0) {
                    updatefavorites8Tab(favorites8, favoriteConfig8)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites8), ContextCompat.getDrawable(this, R.drawable.tab_favorites8)!!, R.id.main_tabhost_10)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites9 != null && favorites9.size > 0) {
                    updatefavorites9Tab(favorites9, favoriteConfig9)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites9), ContextCompat.getDrawable(this, R.drawable.tab_favorites9)!!, R.id.main_tabhost_11)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites10 != null && favorites10.size > 0) {
                    updatefavorites10Tab(favorites10, favoriteConfig10)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites10), ContextCompat.getDrawable(this, R.drawable.tab_favorites10)!!, R.id.main_tabhost_12)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites11 != null && favorites11.size > 0) {
                    updatefavorites11Tab(favorites11, favoriteConfig11)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites11), ContextCompat.getDrawable(this, R.drawable.tab_favorites11)!!, R.id.main_tabhost_13)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites12 != null && favorites12.size > 0) {
                    updatefavorites12Tab(favorites12, favoriteConfig12)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites12), ContextCompat.getDrawable(this, R.drawable.tab_favorites12)!!, R.id.main_tabhost_14)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites13 != null && favorites13.size > 0) {
                    updatefavorites13Tab(favorites13, favoriteConfig13)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites13), ContextCompat.getDrawable(this, R.drawable.tab_favorites13)!!, R.id.main_tabhost_15)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites14 != null && favorites14.size > 0) {
                    updatefavorites14Tab(favorites14, favoriteConfig14)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites14), ContextCompat.getDrawable(this, R.drawable.tab_favorites14)!!, R.id.main_tabhost_16)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites15 != null && favorites15.size > 0) {
                    updatefavorites15Tab(favorites15, favoriteConfig15)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites15), ContextCompat.getDrawable(this, R.drawable.tab_favorites15)!!, R.id.main_tabhost_17)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites16 != null && favorites16.size > 0) {
                    updatefavorites16Tab(favorites16, favoriteConfig16)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites16), ContextCompat.getDrawable(this, R.drawable.tab_favorites16)!!, R.id.main_tabhost_18)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites17 != null && favorites17.size > 0) {
                    updatefavorites17Tab(favorites17, favoriteConfig17)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites17), ContextCompat.getDrawable(this, R.drawable.tab_favorites17)!!, R.id.main_tabhost_19)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites18 != null && favorites18.size > 0) {
                    updatefavorites18Tab(favorites18, favoriteConfig18)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites18), ContextCompat.getDrawable(this, R.drawable.tab_favorites18)!!, R.id.main_tabhost_20)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites19 != null && favorites19.size > 0) {
                    updatefavorites19Tab(favorites19, favoriteConfig19)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites19), ContextCompat.getDrawable(this, R.drawable.tab_favorites19)!!, R.id.main_tabhost_21)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites20 != null && favorites20.size > 0) {
                    updatefavorites20Tab(favorites20, favoriteConfig20)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites20), ContextCompat.getDrawable(this, R.drawable.tab_favorites20)!!, R.id.main_tabhost_22)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

                if (favorites21 != null && favorites21.size > 0) {
                    updatefavorites21Tab(favorites21, favoriteConfig21)
                    tabIconHelper.newTabSpec(getString(R.string.tab_favorites21), ContextCompat.getDrawable(this, R.drawable.tab_favorites21)!!, R.id.main_tabhost_23)
                } else {
                    main_tabhost_2.visibility = View.GONE
                }

            }
        }).start()

        if (CheckRootStatus.lastCheckResult && krScriptConfig.allowHomePage) {
            val home = FragmentHome()
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_tabhost_cpu, home)
            transaction.commitAllowingStateLoss()
        }

        if (!(checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE) && checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE))) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE), 111);
        }
    }

    private fun getItems(pageNode: PageNode): ArrayList<NodeInfoBase>? {
        var items: ArrayList<NodeInfoBase>? = null

        if (pageNode.pageConfigSh.isNotEmpty()) {
            items = PageConfigSh(this, pageNode.pageConfigSh, null).execute()
        }
        if (items == null && pageNode.pageConfigPath.isNotEmpty()) {
            items = PageConfigReader(this.applicationContext, pageNode.pageConfigPath, null).readConfigXml()
        }

        return items
    }

    private fun updateFavoritesTab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favoritesFragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites, favoritesFragment).commitAllowingStateLoss()
    }

    private fun updateFavorites1Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites1Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites1, favorites1Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites2Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites2Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites2, favorites2Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites3Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites3Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites3, favorites3Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites4Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites4Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites4, favorites4Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites5Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites5Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites5, favorites5Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites6Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites6Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites6, favorites6Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites7Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites7Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites7, favorites7Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites8Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites8Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites8, favorites8Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites9Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites9Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites9, favorites9Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites10Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites10Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites10, favorites10Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites11Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites11Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites11, favorites11Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites12Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites12Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites12, favorites12Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites13Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites13Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites13, favorites13Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites14Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites14Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites14, favorites14Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites15Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites15Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites15, favorites15Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites16Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites16Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites16, favorites16Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites17Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites17Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites17, favorites17Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites18Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites18Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites18, favorites18Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites19Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites19Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites19, favorites19Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites20Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites20Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites20, favorites20Fragment).commitAllowingStateLoss()
    }
    private fun updateFavorites21Tab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val favorites21Fragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, true), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_favorites21, favorites21Fragment).commitAllowingStateLoss()
    }

    private fun updateMoreTab(items: ArrayList<NodeInfoBase>, pageNode: PageNode) {
        val allItemFragment = ActionListFragment.create(items, getKrScriptActionHandler(pageNode, false), null, ThemeModeState.getThemeMode())
        supportFragmentManager.beginTransaction().replace(R.id.list_pages, allItemFragment).commitAllowingStateLoss()
    }

    private fun reloadFavoritesTab() {
        Thread(Runnable {
            val favoritesConfig = krScriptConfig.favoriteConfig
            val favorites = getItems(favoritesConfig)
            favorites?.run {
                handler.post {
                    updateFavoritesTab(this, favoritesConfig)
                }
            }
        }).start()
    }

    private fun reloadMoreTab() {
        Thread(Runnable {
            val page2Config = krScriptConfig.pageListConfig
            val pages = getItems(page2Config)

            pages?.run {
                handler.post {
                    updateMoreTab(this, page2Config)
                }
            }
        }).start()
    }
    
    private fun reloadfavorites1Tab() {
        Thread(Runnable {
            val favoriteConfig1 = krScriptConfig.favoriteConfig
            val favorites1 = getItems(favoriteConfig1)
            favorites1?.run {
                handler.post {
                    updatefavorites1Tab(this, favoriteConfig1)
                }
            }
        }).start()
    }

    private fun reloadfavorites2Tab() {
        Thread(Runnable {
            val favoriteConfig2 = krScriptConfig.favoriteConfig
            val favorites2 = getItems(favoriteConfig2)
            favorites2?.run {
                handler.post {
                    updatefavorites2Tab(this, favoriteConfig2)
                }
            }
        }).start()
    }

    private fun reloadfavorites3Tab() {
        Thread(Runnable {
            val favoriteConfig3 = krScriptConfig.favoriteConfig
            val favorites3 = getItems(favoriteConfig3)
            favorites3?.run {
                handler.post {
                    updatefavorites3Tab(this, favoriteConfig3)
                }
            }
        }).start()
    }

    private fun reloadfavorites4Tab() {
        Thread(Runnable {
            val favoriteConfig4 = krScriptConfig.favoriteConfig
            val favorites4 = getItems(favoriteConfig4)
            favorites4?.run {
                handler.post {
                    updatefavorites4Tab(this, favoriteConfig4)
                }
            }
        }).start()
    }

    private fun reloadfavorites5Tab() {
        Thread(Runnable {
            val favoriteConfig5 = krScriptConfig.favoriteConfig
            val favorites5 = getItems(favoriteConfig5)
            favorites5?.run {
                handler.post {
                    updatefavorites5Tab(this, favoriteConfig5)
                }
            }
        }).start()
    }

    private fun reloadfavorites6Tab() {
        Thread(Runnable {
            val favoriteConfig6 = krScriptConfig.favoriteConfig
            val favorites6 = getItems(favoriteConfig6)
            favorites6?.run {
                handler.post {
                    updatefavorites6Tab(this, favoriteConfig6)
                }
            }
        }).start()
    }

    private fun reloadfavorites7Tab() {
        Thread(Runnable {
            val favoriteConfig7 = krScriptConfig.favoriteConfig
            val favorites7 = getItems(favoriteConfig7)
            favorites7?.run {
                handler.post {
                    updatefavorites7Tab(this, favoriteConfig7)
                }
            }
        }).start()
    }

    private fun reloadfavorites8Tab() {
        Thread(Runnable {
            val favoriteConfig8 = krScriptConfig.favoriteConfig
            val favorites8 = getItems(favoriteConfig8)
            favorites8?.run {
                handler.post {
                    updatefavorites8Tab(this, favoriteConfig8)
                }
            }
        }).start()
    }

    private fun reloadfavorites9Tab() {
        Thread(Runnable {
            val favoriteConfig9 = krScriptConfig.favoriteConfig
            val favorites9 = getItems(favoriteConfig9)
            favorites9?.run {
                handler.post {
                    updatefavorites9Tab(this, favoriteConfig9)
                }
            }
        }).start()
    }

    private fun reloadfavorites10Tab() {
        Thread(Runnable {
            val favoriteConfig10 = krScriptConfig.favoriteConfig
            val favorites10 = getItems(favoriteConfig10)
            favorites10?.run {
                handler.post {
                    updatefavorites10Tab(this, favoriteConfig10)
                }
            }
        }).start()
    }

    private fun reloadfavorites11Tab() {
        Thread(Runnable {
            val favoriteConfig11 = krScriptConfig.favoriteConfig
            val favorites11 = getItems(favoriteConfig11)
            favorites11?.run {
                handler.post {
                    updatefavorites11Tab(this, favoriteConfig11)
                }
            }
        }).start()
    }

    private fun reloadfavorites12Tab() {
        Thread(Runnable {
            val favoriteConfig12 = krScriptConfig.favoriteConfig
            val favorites12 = getItems(favoriteConfig12)
            favorites12?.run {
                handler.post {
                    updatefavorites12Tab(this, favoriteConfig12)
                }
            }
        }).start()
    }

    private fun reloadfavorites13Tab() {
        Thread(Runnable {
            val favoriteConfig13 = krScriptConfig.favoriteConfig
            val favorites13 = getItems(favoriteConfig13)
            favorites13?.run {
                handler.post {
                    updatefavorites13Tab(this, favoriteConfig13)
                }
            }
        }).start()
    }

    private fun reloadfavorites14Tab() {
        Thread(Runnable {
            val favoriteConfig14 = krScriptConfig.favoriteConfig
            val favorites14 = getItems(favoriteConfig14)
            favorites14?.run {
                handler.post {
                    updatefavorites14Tab(this, favoriteConfig14)
                }
            }
        }).start()
    }

    private fun reloadfavorites15Tab() {
        Thread(Runnable {
            val favoriteConfig15 = krScriptConfig.favoriteConfig
            val favorites15 = getItems(favoriteConfig15)
            favorites15?.run {
                handler.post {
                    updatefavorites15Tab(this, favoriteConfig15)
                }
            }
        }).start()
    }

    private fun reloadfavorites16Tab() {
        Thread(Runnable {
            val favoriteConfig16 = krScriptConfig.favoriteConfig
            val favorites16 = getItems(favoriteConfig16)
            favorites16?.run {
                handler.post {
                    updatefavorites16Tab(this, favoriteConfig16)
                }
            }
        }).start()
    }

    private fun reloadfavorites17Tab() {
        Thread(Runnable {
            val favoriteConfig17 = krScriptConfig.favoriteConfig
            val favorites17 = getItems(favoriteConfig17)
            favorites17?.run {
                handler.post {
                    updatefavorites17Tab(this, favoriteConfig17)
                }
            }
        }).start()
    }

    private fun reloadfavorites18Tab() {
        Thread(Runnable {
            val favoriteConfig18 = krScriptConfig.favoriteConfig
            val favorites18 = getItems(favoriteConfig18)
            favorites18?.run {
                handler.post {
                    updatefavorites18Tab(this, favoriteConfig18)
                }
            }
        }).start()
    }

    private fun reloadfavorites19Tab() {
        Thread(Runnable {
            val favoriteConfig19 = krScriptConfig.favoriteConfig
            val favorites19 = getItems(favoriteConfig19)
            favorites19?.run {
                handler.post {
                    updatefavorites19Tab(this, favoriteConfig19)
                }
            }
        }).start()
    }

    private fun reloadfavorites20Tab() {
        Thread(Runnable {
            val favoriteConfig20 = krScriptConfig.favoriteConfig
            val favorites20 = getItems(favoriteConfig20)
            favorites20?.run {
                handler.post {
                    updatefavorites20Tab(this, favoriteConfig20)
                }
            }
        }).start()
    }

    private fun reloadfavorites21Tab() {
        Thread(Runnable {
            val favoriteConfig21 = krScriptConfig.favoriteConfig
            val favorites21 = getItems(favoriteConfig21)
            favorites21?.run {
                handler.post {
                    updatefavorites21Tab(this, favoriteConfig21)
                }
            }
        }).start()
    }


    private fun getKrScriptActionHandler(pageNode: PageNode, isFavoritesTab: Boolean): KrScriptActionHandler {
        return object : KrScriptActionHandler {
            override fun onActionCompleted(runnableNode: RunnableNode) {
                if (runnableNode.autoFinish ) {
                    finishAndRemoveTask()
                } else if (runnableNode.reloadPage) {
                    // TODO:多线程优化
                    if (isFavoritesTab) {
                        reloadFavoritesTab()
                    } else {
                        reloadMoreTab()
                    }
                }
            }

            override fun addToFavorites(clickableNode: ClickableNode, addToFavoritesHandler: KrScriptActionHandler.AddToFavoritesHandler) {
                val page = if (clickableNode is PageNode) {
                    clickableNode
                } else if (clickableNode is RunnableNode) {
                    pageNode
                } else {
                    return
                }

                val intent = Intent()

                intent.component = ComponentName(this@MainActivity.applicationContext, ActionPage::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)

                if (clickableNode is RunnableNode) {
                    intent.putExtra("autoRunItemId", clickableNode.key)
                }
                intent.putExtra("page", page)

                addToFavoritesHandler.onAddToFavorites(clickableNode, intent)
            }

            override fun onSubPageClick(pageNode: PageNode) {
                _openPage(pageNode)
            }

            override fun openFileChooser(fileSelectedInterface: ParamsFileChooserRender.FileSelectedInterface): Boolean {
                return chooseFilePath(fileSelectedInterface)
            }
        }
    }

    private var fileSelectedInterface: ParamsFileChooserRender.FileSelectedInterface? = null
    private val ACTION_FILE_PATH_CHOOSER = 65400
    private val ACTION_FILE_PATH_CHOOSER_INNER = 65300

    private fun chooseFilePath(extension: String) {
        try {
            val intent = Intent(this, ActivityFileSelector::class.java)
            intent.putExtra("extension", extension)
            startActivityForResult(intent, ACTION_FILE_PATH_CHOOSER_INNER)
        } catch (ex: java.lang.Exception) {
            Toast.makeText(this, "启动内置文件选择器失败！", Toast.LENGTH_SHORT).show()
        }
    }

    private fun chooseFilePath(fileSelectedInterface: ParamsFileChooserRender.FileSelectedInterface): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, getString(R.string.kr_write_external_storage), Toast.LENGTH_LONG).show()
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 2);
            return false
        } else {
            return try {
                val suffix = fileSelectedInterface.suffix()
                if (suffix != null && suffix.isNotEmpty()) {
                    chooseFilePath(suffix)
                } else {
                    val intent = Intent(Intent.ACTION_GET_CONTENT);
                    val mimeType = fileSelectedInterface.mimeType()
                    if (mimeType != null) {
                        intent.type = mimeType
                    } else {
                        intent.type = "*/*"
                    }
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    startActivityForResult(intent, ACTION_FILE_PATH_CHOOSER);
                }
                this.fileSelectedInterface = fileSelectedInterface
                true;
            } catch (ex: java.lang.Exception) {
                false
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ACTION_FILE_PATH_CHOOSER) {
            val result = if (data == null || resultCode != Activity.RESULT_OK) null else data.data
            if (fileSelectedInterface != null) {
                if (result != null) {
                    val absPath = getPath(result)
                    fileSelectedInterface?.onFileSelected(absPath)
                } else {
                    fileSelectedInterface?.onFileSelected(null)
                }
            }
            this.fileSelectedInterface = null
        } else if (requestCode == ACTION_FILE_PATH_CHOOSER_INNER) {
            val absPath = if (data == null || resultCode != Activity.RESULT_OK) null else data.getStringExtra("file")
            fileSelectedInterface?.onFileSelected(absPath)
            this.fileSelectedInterface = null
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun getPath(uri: Uri): String? {
        try {
            return FilePathResolver().getPath(this, uri)
        } catch (ex: Exception) {
            return null
        }
    }

    fun _openPage(pageNode: PageNode) {
        OpenPageHelper(this).openPage(pageNode)
    }

    private fun getDensity(): Int {
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        return dm.densityDpi
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)

        menu.findItem(R.id.action_graph).isVisible = (main_tabhost_cpu.visibility == View.VISIBLE)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
           R.id.option_menu_info -> {
                val intent = Intent()
                intent.setClass(this,AboutActivity::class.java)
                startActivity(intent)
            }
            
            R.id.option_menu_reboot -> {
                DialogPower(this).showPowerMenu()
            }
            R.id.action_graph -> {
                if (FloatMonitor.isShown == true) {
                    FloatMonitor(this).hidePopupWindow()
                    return false
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(this)) {
                        FloatMonitor(this).showPopupWindow()
                        Toast.makeText(this, getString(R.string.float_monitor_tips), Toast.LENGTH_LONG).show()
                    } else {
                        //若没有权限，提示获取
                        //val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                        //startActivity(intent);
                        val intent = Intent()
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        intent.action = "android.settings.APPLICATION_DETAILS_SETTINGS"
                        intent.data = Uri.fromParts("package", this.packageName, null)

                        Toast.makeText(applicationContext, getString(R.string.permission_float), Toast.LENGTH_LONG).show()

                        try {
                            startActivity(intent)
                        } catch (ex: Exception) {
                        }
                    }
                } else {
                    FloatMonitor(this).showPopupWindow()
                    Toast.makeText(this, getString(R.string.float_monitor_tips), Toast.LENGTH_LONG).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
