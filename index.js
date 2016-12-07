import React, {PropTypes} from 'react'
import {requireNativeComponent, View, NativeModules} from 'react-native'

class RCTVrVideoView extends React.Component {
  static get defaultProps () {
    return {
      displayMode: NativeModules.RNVrModule.DISPLAY_MODE.EMBEDDED,
      paused: false
    }
  }

  static get propTypes () {
    return {
      src: PropTypes.shape({
        uri: PropTypes.string.isRequired,
        format: PropTypes.oneOf(Object.values(NativeModules.RNVrModule.FORMAT)).isRequired,
        type: PropTypes.oneOf(Object.values(NativeModules.RNVrModule.TYPE)).isRequired
      }).isRequired,
      displayMode: PropTypes.oneOf(Object.values(NativeModules.RNVrModule.DISPLAY_MODE)),
      paused: PropTypes.bool,
      ...View.propTypes
    }
  }
}

const native = requireNativeComponent('RCTVrVideoView', RCTVrVideoView)
native.constants = NativeModules.RNVrModule

export default native
