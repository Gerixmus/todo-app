# todo-app
This application is a simple todo list. You can add items with name, description and hour. If you click on the item it will be marked as completed. If you want to mark it as incomplete again just press the task again.

## Requirements

### Content Provider
I created `TaskItemContentProvider.kt` where I defined the CRUD functions. I also implemented `TaskItemContract.kt` for helping with the URI. Lastly, I updated `AndroidManifes.xml` to contain the provider section. Unfortunately, after trying to retireve data with this content provider inside `TaskItemRepository.kt`, the application kept crashing so I decided to switch to DAO for CRUD operations.

### Fragments
I created a bottom sheet dialog fragment for inserting and editing data.

### Android Design
Requirement was to add at least 2 design principles as seen in class. 
- I'm using vector assets for adding and displaying finished or unfinished tasks.
- I'm using surfaces to make sure each task is separated from each other.
- I implemented FAB for adding new tasks. It sits in the bottom right corner.
- I defined 3 colors in my `colors.xml`.

### Espresso (UI testing)
I created 3 UI tests inside `ExampleInstrumentedTest.kt`.
- `useAppContext` Obtains app context and verifies if the package name is correct. This was a sample test.
- `testNewTaskButton` Performs a click action on my button and checks if dialog with text "New Task" appears.
- `testRecyclerView` Looks for recycler view and checks if it's displayed correctly.
- `testEditTaskItem` Creates a sample task item, calls `editTaskItem` on it and checks if dialog with text "Edit Task" is displayed.
