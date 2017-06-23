<template>
  <div>
    <select @change="onChange($event.target.value)">
     <option disabled value="">Choisissez un utilisateur ...</option>
     <option v-for="utilisateur in utilisateurs" :value="utilisateur.handle">
       {{ utilisateur.prenom }} {{ utilisateur.nom }}
     </option>
    </select>
  </div>
</template>

<script>
import Vue from 'vue'
import Resource from 'vue-resource'

Vue.use(Resource)

export default {
  name: 'timeline',
  data () {
    return {
      utilisateurs: []
    }
  },
  created () {
    this.getUtilisateurs()
  },
  methods: {
    getUtilisateurs: function () {
      // GET /someUrl
        this.$http.get('http://localhost:8080/utilisateurs').then(response => {
          this.utilisateurs = response.body;
        }, response => {
          // error callback
        });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
