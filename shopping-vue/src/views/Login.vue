<template>
  <div>
    <el-form
      ref="loginForm"
      :model="form"
      :rules="rules"
      label-width="80px"
      class="login-box"
    >
      <h3 class="login-title">Sign in</h3>
      <el-form-item label="username" prop="username">
        <el-input
          type="text"
          placeholder="Please enter the username"
          v-model="form.username"
        />
      </el-form-item>
      <el-form-item label="password" prop="password">
        <el-input
          type="password"
          placeholder="Please enter the password"
          v-model="form.password"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="onSubmit('loginForm')"
          >Login</el-button
        >
      </el-form-item>
    </el-form>

    <el-dialog
      title="Reminder"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose"
    >
      <span>Please enter the username and password</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false"
          >determine</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { usersLogin } from "@/api/getData.js";

export default {
  name: "Login",
  data() {
    return {
      form: {
        username: "",
        password: "",
      },
      rules: {
        username: [
          { required: true, message: "username required", trigger: "blur" },
        ],
        password: [
          { required: true, message: "password required", trigger: "blur" },
        ],
      },
      
      dialogVisible: false,
    };
  },
  methods: {
    onSubmit(formName) {
      
      this.$refs[formName].validate((valid) => {
        
        if (valid) {
        
          usersLogin(this.form.username, this.form.password).then((res) => {
            if (res.data[0].responseMsg == "login successfully") {
              this.$router.push("/main");
              this.$store.commit("setCurrentUser", this.form.username);
            }

          });
        } else {
          this.dialogVisible = true;
          return false;
        }
      });
    },
    handleClose() {
      return false;
    },
  },
};
</script>

<style scoped>
.login-box {
  border: 1px solid #dcdfe6;
  width: 350px;
  margin: 180px auto;
  padding: 35px 35px 15px 35px;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 25px #909399;
}
.login-title {
  text-align: center;
  margin: 0 auto 40px auto;
  color: #303133;
}
</style>
