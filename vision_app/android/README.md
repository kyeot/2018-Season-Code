# Team 2783 KYEOT Object Detection with Tensorflow

This app is a modified version of the official Tensorflow Object Detection app demo which can be found here: https://github.com/tensorflow/tensorflow/tree/master/tensorflow/examples/android

This has been modified to communicate with the RoboRIO based upon Team 254's code which can be found here:
https://github.com/Team254/FRC-2017-Public
 
The most important part of this app is the frozen inference graph which can be found under the "assets" folder. This essentially is a set of weighted values that tell Tensorflow what a Power Up cube actually is, allowing it to be recognized.

# To do
- Remove reference to AppContext in MultiBoxTracker (or at least reduce it). This is used far too often (every vision update) and shouldn't be.
- Optimize inference graph for lower latency. This will involve generating a new inference graph from the raw output of the neural training and then quantizing it. 
- Confirm that timestamps are being applied to targets accurately. This is very important for latency compensation and I have no idea if the method I used to apply timestamps is anywhere near accurate. I hope it is but this is an important test.
