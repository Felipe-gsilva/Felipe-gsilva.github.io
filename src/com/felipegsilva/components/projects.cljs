(ns com.felipegsilva.components.projects
  (:require
   [helix.core :refer [defnc $ <>]]
   [helix.dom :as d]
   [helix.hooks :as hooks]
   [com.felipegsilva.components.svg :as svg]))

(defnc project-card [{:keys [project is-dark?]}]
  (let [{:keys [name description html_url language stargazers_count forks_count]} project]
    (d/a {:href html_url
          :target "_blank"
          :class (str "flex flex-col p-6 rounded-xl border transition-all duration-300 hover:-translate-y-1 hover:shadow-lg "
                      (if is-dark?
                        "border-gray-700 bg-gray-900/50 hover:border-yellow-600/50 hover:bg-gray-800"
                        "border-gray-200 bg-white hover:border-yellow-600/50 hover:bg-gray-50"))}
         (d/div {:class "flex justify-between items-start mb-4"}
                (d/h3 {:class (str "text-xl font-bold " (if is-dark? "text-white" "text-gray-900"))} name)
                ($ svg/github {:class (str "w-5 h-5 " (if is-dark? "text-gray-400" "text-gray-500"))}))
         
         (d/p {:class (str "mb-6 text-sm flex-grow " (if is-dark? "text-gray-400" "text-gray-600"))}
              (or description "No description available."))
         
         (d/div {:class "flex items-center space-x-4 text-sm"}
                (when language
                  (d/div {:class "flex items-center space-x-1"}
                         (d/span {:class "w-3 h-3 rounded-full bg-yellow-500"})
                         (d/span {:class (if is-dark? "text-gray-300" "text-gray-700")} language)))
                
                (d/div {:class "flex items-center space-x-1"}
                       (d/span {:class (if is-dark? "text-yellow-500" "text-yellow-600")} "★")
                       (d/span {:class (if is-dark? "text-gray-300" "text-gray-700")} stargazers_count))
                
                (d/div {:class "flex items-center space-x-1"}
                       (d/span {:class (if is-dark? "text-gray-500" "text-gray-600")} "⑂")
                       (d/span {:class (if is-dark? "text-gray-300" "text-gray-700")} forks_count))))))

(defnc projects-list [{:keys [projects is-dark?]}]
  (d/div {:class "grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 w-full"}
         (for [project projects]
           ($ project-card {:key (:id project) :project project :is-dark? is-dark?}))))

(defnc projects-page [{:keys [is-dark?]}]
  (let [[projects set-projects] (hooks/use-state [])
        [loading? set-loading?] (hooks/use-state true)]
    
    (hooks/use-effect
      :once
      (-> (js/fetch "resources/data/projects.json")
          (.then #(.json %))
          (.then #(do (set-projects (js->clj % :keywordize-keys true))
                      (set-loading? false)))
          (.catch #(do (js/console.error "Failed to fetch projects" %)
                       (set-loading? false)))))

    (d/div {:class "w-full min-h-screen py-12 px-4 md:px-8"}
           (d/div {:class "max-w-7xl mx-auto"}
                  (d/div {:class "mb-12 text-center"}
                         (d/h1 {:class (str "text-4xl md:text-5xl font-bold mb-4 "
                                            (if is-dark? "text-white" "text-gray-900"))}
                               "Projects")
                         (d/p {:class (str "text-lg " (if is-dark? "text-gray-400" "text-gray-600"))}
                              "A collection of my open source work and experiments."))
                  
                  (if loading?
                    (d/div {:class "flex justify-center items-center h-64"}
                           (d/div {:class "animate-spin rounded-full h-12 w-12 border-t-2 border-b-2 border-yellow-500"}))
                    ($ projects-list {:projects projects :is-dark? is-dark?}))))))
