<template>
  <view class="alarmManagement">
    <!-- Map -->
    <view class="map" :style="[{height: winHeight + 'px'}]">
      <web-view src="/static/html/map.html"></web-view>
    </view>
  </view>
</template>