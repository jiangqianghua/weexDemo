# Introduction

This boilerplate is targeted towards large, serious projects and assumes you are somewhat familiar with Webpack and `weex-loader`. 

## Quickstart

To use this template, scaffold a project with [weexpack v1.1.1+](https://github.com/weexteam/weex-pack).

``` bash
$ npm install -g weex-toolkit
$ weex create my-project # default will create the webpack template
$ cd my-project && npm start
```

## How to use less/sass/pug

Take `sass` for example:

```
$ npm i node-sass sass-loader --save
```

Then, you just need to change the `style` tag as: `<style lang="sass"><style>`.

## How to create your own template

See [How-to-create-your-own-template](https://github.com/weex-templates/How-to-create-your-own-template).

#安装weexpack，方便打包编译
>>cnpm install -g weexpack
#添加android支持
>>weex platform add android
#运行
>>weexpack run android
#编译
>>weexpack build android
#生成签名
>>keytool -genkey -alias runan.keystore -keyalg RSA -validity 1000 -keystore runan.keystore
#开始签名
>>jarsigner -verbose -keystore runan.keystore -signedjar runan.apk app-release-unsigned.apk runan.keystore