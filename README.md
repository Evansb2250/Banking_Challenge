# Banking_Challenge

Code Challenge for Veryable

In this Project I used the MVVM Design pattern (excluding a database).

I used a RecyclerView with an ListAdapter to manage the list of items.

I used databinding to get access to each individual item in the adapter when clicking on the display.
I also created binding adapter functions to determine when to display an image of a bank or card.

The list of of accounts is managed in a LiveData list variable where it is initialized from the global livedata variable found in the repository.
Since the application makes request to the Veryable webservice API with each configuration change, I didn't need to use a ViewModelFactory method to restore the state of the viewModel variable. 


I made sure to reduce any hard coding of variables, and created separate styles for the different view in the application.
I also made sure to complete the requirements mentioned in the wireFrame.














