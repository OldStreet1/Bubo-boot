<template>
  <div>
    <el-dialog v-bind="$attrs" v-on="$listeners" @open="onOpen" @close="onClose" title="Dialog Titile">
      <el-row :gutter="15">
        <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
          <el-col :span="24">
            <el-form-item label="类型编码" prop="typeCode">
              <el-input v-model="formData.typeCode" placeholder="请输入类型编码" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="类型名称" prop="typeName">
              <el-input v-model="formData.typeName" placeholder="请输入类型名称" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="地理类型" prop="geographyType">
              <el-select v-model="formData.geographyType" placeholder="请选择地理类型" clearable
                         :style="{width: '100%'}">
                <el-option v-for="(item, index) in geographyTypeOptions" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="线的颜色" prop="strokeColour" required>
              <el-color-picker v-model="formData.strokeColour" size="medium"></el-color-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="填充颜色" prop="fillColour" required>
              <el-color-picker v-model="formData.fillColour" size="medium"></el-color-picker>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <div slot="footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="handelConfirm">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  inheritAttrs: false,
  components: {},
  props: [],
  data() {
    return {
      formData: {
        typeCode: undefined,
        typeName: undefined,
        geographyType: undefined,
        strokeColour: null,
        fillColour: '#FF0000',
      },
      rules: {
        typeCode: [{
          required: true,
          message: '请输入类型编码',
          trigger: 'blur'
        }],
        typeName: [{
          required: true,
          message: '请输入类型名称',
          trigger: 'blur'
        }],
        geographyType: [{
          required: true,
          message: '请选择地理类型',
          trigger: 'change'
        }],
      },
      geographyTypeOptions: [{
        "label": "选项一",
        "value": "标点"
      }, {
        "label": "选项二",
        "value": "区域"
      }, {
        "label": "",
        "value": "线路"
      }],
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    onOpen() {},
    onClose() {
      this.$refs['elForm'].resetFields()
    },
    close() {
      this.$emit('update:visible', false)
    },
    handelConfirm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        this.close()
      })
    },
  }
}

</script>
<style>
</style>
