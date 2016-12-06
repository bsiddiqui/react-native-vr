import {PropTypes} from 'react'
import {requireNativeComponent, View} from 'react-native'

module.exports = requireNativeComponent('RCTVrVideoView', {
  name: 'VrVideoView',
  propTypes: {
    src: PropTypes.string,
    ...View.propTypes
  }
})
