# GridBoard
Android Java Library


## Installation

First you need to add `jitpack` repositories in your root build.gradle at the end of repositories
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Then you can get the **GridBoard** library by adding this dependency

```
dependencies {
	implementation 'com.github.manalkaff:GridBoard::0.3'
}
```

## Usage

To use GridBoard, you need `RecyclerView` as the GridBoard view, and `EditText` as the input for **GridBoard**
### View initialization
```
private EditText editText;
private RecyclerView gbview;

editText = findViewById(R.id.textinput);
gbview = findViewById(R.id.gridboard_view);
```

After that you can implement **GridBoard** by doing this.
### GridBoard Implementation
```
GridBoard gridBoard = new GridBoard(this, gbview);
gridBoard.setInputConnection(editText.onCreateInputConnection(new EditorInfo()));
```

And thats all you need.
