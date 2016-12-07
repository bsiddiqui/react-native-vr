/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react'
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native'
import Button from 'react-native-button'

import Vr from 'react-native-vr'

export default class example extends Component {
  constructor (props) {
    super(props)

    this.state = {
      paused: false,
      displayMode: Vr.constants.DISPLAY_MODE.EMBEDDED
    }
  }

  render () {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
        <Vr
          src={{
            uri: 'https://streams.kolor.com/streams/0e733b85-ce09-47a2-8d8b-992e3eb4cebf/source.03-1080p_HD.mp4',
            type: Vr.constants.TYPE.MONO,
            format: Vr.constants.FORMAT.DEFAULT
          }}
          paused={this.state.paused}
          displayMode={this.state.displayMode}
          style={{
            height: 300,
            width: 300
          }} />
        <View>
          <Button onPress={() => this.setState({ paused: !this.state.paused })}>
            {this.state.paused ? 'Play' : 'Pause'}
          </Button>
          <Button onPress={() => this.setState({ displayMode: Vr.constants.DISPLAY_MODE.FULLSCREEN_MONO })}>
            Go Fullscreen
          </Button>
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5
  }
})

AppRegistry.registerComponent('example', () => example)
