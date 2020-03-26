# Applying Sharing feature in your app
How to share text and images through app

1. Add setHasOptionsMenu(true) to onCreateView() in our fragment from where you want to share text or images.

2. Create a getShareIntent method.( Get the args and build the shareIntent inside.)          
We’ll create a getShareIntent method and move our (YourFragmentArgs).fromBundle there. 
We’ll use shareCompat to create our share Implicit intent. We can call ShareCompat.IntentBuilder.from(activity), 
set our text, and then set the MIME type, finishing off by building our intent.

3. Create a shareSuccess method (in your Fragment)that starts the activity from the share Intent
Next, we’ll create our shareSuccess method, which gets the Intent from getShareIntent and calls startActivity to begin sharing.

4. Override onCreateOptionsMenu and inflate our share_menu.
Override onCreateOptionsMenu and begin by inflating the share_menu. 
Then we’ll get the shareIntent using getShareIntent() and call resolveActivity using the packageManger to 
make sure our shareIntent resolves to an activity.

5. Hide the sharing menu item if the sharing intent doesn’t resolve to an Activity
If the result equals null, which means that it doesn’t resolve, 
we find our sharing menu item from the inflated menu and set its visibility to false.

// Showing the Share Menu Item Dynamically
override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
   super.onCreateOptionsMenu(menu, inflater)
   inflater?.inflate(R.menu.share_menu, menu)
   // check if the activity resolves
   if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
       // hide the menu item if it doesn't resolve
       menu?.findItem(R.id.share)?.setVisible(false)
   }
}

6. Override onOptionsItemSelected to link the menu to the shareSuccess action
 Override onOptionsItemSelected. When the menuitem id matches R.id.share, call the shareSuccess method.
 
 






