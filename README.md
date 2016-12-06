# React Native Virtual Reality

### Setup

Install the module using `npm i -S react-native-vr` and link it using
`react-native link react-native-vr`. Also make sure you have the following lines
in your `android/build.gradle`:

```gradle
allprojects {
    repositories {
        ...
        // IMPORTANT: Make sure you have the following line
        flatDir { dirs "$rootDir/../node_modules/react-native-vr/android/libs" }
    }
}
```

### Usage

The following example is everything you can do for now.

```javascript
import Vr from 'react-native-vr'

...

  render() {
    return <Vr
      src="https://my-awesome-3d-video.com"
      style={{ height: 100, width: 100 }} />
  }
```
