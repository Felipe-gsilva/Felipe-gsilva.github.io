(ns com.felipegsilva.components.projects
  (:require [helix.core :refer [defnc $]]
            [helix.dom :as d]))

(def projects-data
  [{:name "Claquete"
    :subtitle "Hybrid Recommendation Engine"
    :url "https://github.com/luminal-solutions/claquete"
    :year "2026"
    :description "Scalable movie platform in React and PostgreSQL. Vector search (Snowflake Arctic Embed) with advanced re-ranking via ParadeDB (BM25) and Reciprocal Rank Fusion (RRF). Auth management via Supabase and data integration with FDW."
    :tags ["React" "PostgreSQL" "Vector Search" "BM25" "Supabase"]}
   {:name "TableWare"
    :subtitle "Columnar Database for Datalog (Rust)"
    :url "https://github.com/study-group-cssd/ColumnarDataLog/"
    :year "2026"
    :description "Co-developed a single-instance columnar database. Architected an optimized in-memory engine, WAL persistence, multiple indexing trees (LSM and B-link), and an API execution pipeline mirroring Datomic structures."
    :tags ["Rust" "LSM Tree" "B-link Tree" "WAL" "Datalog"]}
   {:name "Gaveta"
    :subtitle "Database Engine in C"
    :url "https://github.com/Felipe-gsilva/Gaveta"
    :year "2025"
    :description "Low-level DBMS core engineering. B+ tree indexing, buffer pool management (LRU/Clock policies), and direct binary file manipulation for disk persistence."
    :tags ["C" "B+ Tree" "Buffer Pool" "LRU" "Systems"]}
   {:name "ChicOS"
    :subtitle "OS Simulator in C"
    :url "https://github.com/Felipe-gsilva/ChicOS"
    :year "2025"
    :description "Multithreaded CLI simulator with ncurses interface. Simulation of core OS modules: disk scheduling (SSTF), CPU scheduling (Round Robin), and paged memory allocation with second-chance policy."
    :tags ["C" "ncurses" "OS" "Concurrency" "Scheduling"]}])

(defnc tag-badge [{:keys [label is-dark?]}]
  (d/span {:class (str "text-xs px-2 py-0.5 rounded border "
                       (if is-dark?
                         "border-gray-700 text-gray-400"
                         "border-gray-300 text-gray-500"))}
          label))

(defnc project-item [{:keys [name subtitle url year description tags is-dark?]}]
  (d/div {:class (str "mb-5 p-4 rounded-lg border transition-all duration-75 "
                      (if is-dark?
                        "border-gray-800 hover:border-yellow-600/40"
                        "border-gray-200 hover:border-yellow-500/40"))}
         (d/div {:class "flex flex-col md:flex-row md:justify-between md:items-baseline mb-2 gap-1"}
                (d/div {:class "flex items-center gap-2 flex-wrap"}
                       (d/a {:href url
                             :target "_blank"
                             :class "font-bold hover:text-yellow-600 transition-all duration-75"}
                            name)
                       (d/span {:class "text-gray-500 text-sm"} subtitle))
                (d/span {:class "text-xs text-gray-500 flex-shrink-0"} year))
         (d/p {:class "text-sm leading-relaxed mb-3"} description)
         (d/div {:class "flex flex-wrap gap-2"}
                (map (fn [tag]
                       ($ tag-badge {:key tag :label tag :is-dark? is-dark?}))
                     tags))))

(defnc projects [{:keys [is-dark?]}]
  (d/section {:id "projects" :class "w-full py-12"}
             (d/h2 {:class "text-2xl font-bold mb-2"} "Selected Projects")
             (d/p {:class (str "text-sm mb-4 " (if is-dark? "text-gray-400" "text-gray-500"))}
                  "All projects are available on "
                  (d/a {:href "https://github.com/Felipe-gsilva"
                        :target "_blank"
                        :class "underline hover:text-yellow-600 transition-all duration-75"}
                       "GitHub")
                  ".")
             (d/div {:class (str "border-b mb-8 " (if is-dark? "border-gray-700" "border-gray-200"))})
             (map (fn [{:keys [name subtitle url year description tags]}]
                    ($ project-item {:key name
                                     :name name
                                     :subtitle subtitle
                                     :url url
                                     :year year
                                     :description description
                                     :tags tags
                                     :is-dark? is-dark?}))
                  projects-data)))
