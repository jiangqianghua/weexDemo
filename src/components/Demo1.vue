<template>
  <div>
    <text @click="onClick">Android Toast</text>
    <text @click="onCallBack" class="calbackText">CallBack</text>
  </div>
</template>

<script>
    module.exports = {
        methods: {
            onClick: function () {
                weex.requireModule('myModule').printLog("我是一个测试!");
            },
            onCallBack: function () {
                let func = weex.requireModule('myModule');
                func.nativeCallBack(function (event) {
                    //回调后处理
                    func.printLog('回调: ' + event);
                });
            }
        }
    }
</script>

<style scoped>
  .calbackText{
    margin-top: 100rem;
  }
</style>

