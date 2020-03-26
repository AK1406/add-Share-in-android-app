package com.example.share

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore.Images
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.share.databinding.FragmentQuoteBinding
import kotlinx.android.synthetic.main.fragment_quote.*


/**
 * A simple [Fragment] subclass.
 */
class QuoteFragment : Fragment() {
    private lateinit var binding: FragmentQuoteBinding

    //Inflating and Returning the View with DataBindingUtil
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val  binding = DataBindingUtil.inflate<FragmentQuoteBinding>(
            inflater,
            R.layout.fragment_quote,
            container,
            false
        )
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (menu != null) {
            if (inflater != null) {
                super.onCreateOptionsMenu(menu, inflater)
            }
        }
        inflater?.inflate(R.menu.menu_share, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }
    // Creating our Share Intent
    private fun getShareIntent() : Intent {
       // val args = arguments?.let { QuoteFragmentArgs.fromBundle(it) }
        val shareIntent = Intent(Intent.ACTION_SEND)
        /* to share image
        val screenshotUri: Uri =
           Uri.parse(Images.Media.EXTERNAL_CONTENT_URI.toString() + "/" + quote_image)// to share image
        shareIntent.setType("image/jpeg").putExtra(Intent.EXTRA_TEXT, screenshotUri)  */
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.quote_text))
        //startActivity(Intent.createChooser(shareIntent, "Share image using"));
        return shareIntent
    }
    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}